package com.shoppingcart.shoppingcart.controller;

import com.shoppingcart.shoppingcart.dto.ProductDto;
import com.shoppingcart.shoppingcart.model.Category;
import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.repository.CategoryRepo;
import com.shoppingcart.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDto productDto){
        Optional<Category> category= categoryRepo.findById(productDto.getCategoryId());
        if(!category.isPresent()){
            return "Category id is invalid";
        }
        return productService.addProduct(productDto, category.get());
    }

    @GetMapping("/getAll")
    public List<ProductDto> getAllProducts(){
        List<ProductDto> productDtos =  productService.getAllProducts();
        return  productDtos;
    }
    @GetMapping("/getByCategoryId/{category_id}")
    public List<Product> getAllProducts(int category_id){
        List<Product> products =  productService.getByCategoryId(category_id);
        return  products;
    }

    @PutMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent()){
            return  "Category id is invalid";
        }
        return productService.updateProduct(productDto, productId);
    }

}