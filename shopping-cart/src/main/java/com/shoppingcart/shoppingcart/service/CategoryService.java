package com.shoppingcart.shoppingcart.service;

import com.shoppingcart.shoppingcart.model.Category;

import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.repository.CategoryRepo;

import com.shoppingcart.shoppingcart.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService
{
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;
    public String createCategory(List<Category> categories){
        categoryRepo.saveAll(categories);
        return "Category Created successfully";
    }

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }
    public String  getAllCategoryWithProducts(){
       List<List<String>> result=null;
       List<String> temp=null;
       List<Product> productList=productRepo.findAll();
       for(Product product:productList)
       {
           String categoryName=product.getCategory().getCategoryName();
           System.out.println(categoryName);
           int id=product.getCategory().getId();
//           Category category=product.getCategory();
//           temp.add(categoryName);
           temp.add("Anshu");
//           temp.add(String.valueOf(product.getId()));
//           temp.add(product.getName());
//           temp.add(String.valueOf(product.getQuantity()));
//           temp.add(String.valueOf(product.getPrice()));
           System.out.println(product.getId()+ " "+product.getName());
           result.add(id,temp);
           temp.clear();


       }
       return result;
    }

    public String  updateCategory(int categoryId, Category updateCategory) {
        Category category = categoryRepo.getReferenceById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        categoryRepo.save(category);
        return "Category Updated";
    }
    public String deleteCategory(int categoryId)
    {
        Category deleteCategory=categoryRepo.findById(categoryId).orElse(null);
        categoryRepo.delete(deleteCategory);
        return "Category id "+categoryId+" is deleted successfully";
    }
//    public boolean findById(int categoryId) {
//        return categoryRepo.findById(categoryId).isPresent();
//    }
}
