package com.paytm.LOS.shoppingcartLOS.controller;

import com.paytm.LOS.shoppingcartLOS.entity.Category;
import com.paytm.LOS.shoppingcartLOS.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public String createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);

    }

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

//    @PutMapping("/update/{categoryId}")
//    public String updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category){
//        return categoryService.updateCategory(categoryId, category);
//    }

}
