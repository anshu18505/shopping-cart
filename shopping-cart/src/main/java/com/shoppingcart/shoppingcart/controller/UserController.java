package com.shoppingcart.shoppingcart.controller;

import com.shoppingcart.shoppingcart.dto.ResponseDto;
import com.shoppingcart.shoppingcart.dto.SignInDto;
import com.shoppingcart.shoppingcart.dto.SigninResponseDto;
import com.shoppingcart.shoppingcart.dto.SignupDto;
import com.shoppingcart.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) throws Exception {
        return userService.signup(signupDto);
    }

    @PostMapping("/signin")
    public SigninResponseDto signIn(@RequestBody SignInDto signinDto) throws Exception{
        return userService.signIn(signinDto);
    }
}
