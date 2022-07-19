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
    public List<Product> getAllCategoryWithProducts(int category_id){

//        System.out.println("B");
        return findProductCategoryId(category_id);
//        System.out.println("Anshu");
//        System.out.println("Anshu2");
//        return productList;


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
    public boolean findById(int categoryId) {
        return categoryRepo.findById(categoryId).isPresent();
    }

    public List<Product> findProductCategoryId(int category_id)
    {

        List<Product> productList=productRepo.findAll();
        System.out.print("D");
        List<Product> result=new ArrayList<Product>();
        System.out.print("E");
        for(int i=0;i<productList.size();i++)
        {
            if(productList.get(i).getCategory().getId()==category_id) {
                result.add(productList.get(i));
            }
            else
                continue;
        }
        if(result.size()==0)
            result.add(new Product());
        System.out.print("F");
        System.out.println("Hello adjkwbkfjbwdfjknwefonwe world");

        return result;

    }



//    public List<String> findProductCategoryId(int category_id)
//    {
//
//        List<Product> productList=productRepo.findAll();
//        System.out.print("D");
//        List<String> result=new ArrayList<String>();
//        System.out.print("E");
//        for(int i=0;i<productList.size();i++)
//        {
//            if(productList.get(i).getCategory().getId()==category_id) {
//                result.add("Category Id : "+category_id+" ");
//                result.add(productList.get(i).getName());
//                result.add(String.valueOf(productList.get(i).getQuantity()));
//                result.add(String.valueOf(productList.get(i).getPrice()));
//                result.add(productList.get(i).getDescription());
//
//            }
//            else
//                continue;
//        }
//        if(result.size()==0)
//            result.add("");
//        System.out.print("F");
//        System.out.println("Hello adjkwbkfjbwdfjknwefonwe world");
//
//        return result;
//
//    }
}
