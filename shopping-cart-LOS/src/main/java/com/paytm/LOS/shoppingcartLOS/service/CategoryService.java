package com.paytm.LOS.shoppingcartLOS.service;

import com.paytm.LOS.shoppingcartLOS.entity.Category;
import com.paytm.LOS.shoppingcartLOS.repository.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
{
    @Autowired
    private CategoryRepo categoryRepo;

    public String createCategory(Category category){
        categoryRepo.save(category);
        return "Category Created successfully";
    }

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

//    public String  updateCategory(int categoryId, Category updateCategory) {
//        Category category = categoryRepo.getReferenceById(categoryId);
//        category.setCategoryName(updateCategory.getCategoryName());
//        category.setDescription(updateCategory.getDescription());
//        categoryRepo.save(category);
//        return "Category Updated";
//    }

//    public boolean findById(int categoryId) {
//        return categoryRepo.findById(categoryId).isPresent();
//    }
}
