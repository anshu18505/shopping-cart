package com.shoppingcart.shoppingcart.service;

import com.shoppingcart.shoppingcart.model.Category;

import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.repository.CategoryRepo;

import com.shoppingcart.shoppingcart.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<List<String>>  getAllCategoryWithProducts(){
        List<Category> categoryList=categoryRepo.findAll();
        List<List<String>> result=null;
        List<String> temp = null;

        for(Category category:categoryList)
        {

            int id=category.getId();
            temp.add(String.valueOf(id));

            temp.add(category.getCategoryName());
            List<Product> productlist= productRepo.findByCategoryId(id);
            for(Product product: productlist)
            {
                temp.add(product.getName());
                temp.add(product.getDescription());
                temp.add(String.valueOf(product.getQuantity()));
                temp.add(String.valueOf(product.getPrice()));
                result.add(temp);
                temp.clear();
            }

//            System.out.println("Category id :"+id+" "+product.getName()+" ");

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
