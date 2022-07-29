package com.shoppingcart.shoppingcart.controller;

import com.shoppingcart.shoppingcart.model.Category;
import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/addCategory")
    public String createCategory(@RequestBody List<Category> categories){
        return categoryService.createCategory(categories);
    }

    @GetMapping("/getOnlyCategory")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/getProductByCategoryId")
    public List<Product> getAllCategoryItems(@RequestParam ("category_id") int category_id) throws Exception {
        System.out.println("A");
        return categoryService.getAllCategoryWithProducts(category_id);
    }
    @GetMapping("/getAllCategoryItems")
    public List<Category> getAllCategoryItems() throws Exception {
        System.out.println("new function");
        return categoryService.findAllProductCategory();
    }

    @PutMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category){
        return categoryService.updateCategory(categoryId, category);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id)
    {
        return categoryService.deleteCategory(id);
    }

}
