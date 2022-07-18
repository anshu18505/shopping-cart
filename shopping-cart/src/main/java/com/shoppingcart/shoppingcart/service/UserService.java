package com.shoppingcart.shoppingcart.service;

import com.shoppingcart.shoppingcart.dto.ResponseDto;
import com.shoppingcart.shoppingcart.dto.SignInDto;
import com.shoppingcart.shoppingcart.dto.SigninResponseDto;
import com.shoppingcart.shoppingcart.dto.SignupDto;
import com.shoppingcart.shoppingcart.model.User;
import com.shoppingcart.shoppingcart.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public ResponseDto signup(SignupDto signupDto) throws Exception
    {
       if(Objects.nonNull(userRepo.findByEmail(signupDto.getEmail())))
           throw new Exception("User already exists, please signIn");
        String pass_encrypted="";
        try {
            pass_encrypted = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
       User user=new User(signupDto.getFirstName(),signupDto.getLastName(), signupDto.getEmail(), pass_encrypted);
       userRepo.save(user);
       ResponseDto responseDto=new ResponseDto("Success","Account created successfully ");
       return responseDto;


    }
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.
                printHexBinary(digest).toUpperCase();
        return hash;
    }
    public SigninResponseDto signIn(SignInDto signInDto) throws Exception
    {
        if(Objects.isNull(userRepo.findByEmail(signInDto.getEmail())))
            throw new Exception("Invalid User");
        try{
            if(!userRepo.findByEmail(signInDto.getEmail()).getPassword().equals(hashPassword(signInDto.getPassword())))
                throw new Exception("Wrong Password");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new SigninResponseDto("success","Logged in");
    }
}
