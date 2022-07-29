package com.shoppingcart.shoppingcart.service;

import com.shoppingcart.shoppingcart.dto.AddToCartDto;
import com.shoppingcart.shoppingcart.dto.ProductDto;
import com.shoppingcart.shoppingcart.model.Category;
import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.repository.CategoryRepo;
import com.shoppingcart.shoppingcart.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
     ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;


    public String addProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setCategory(category);

//        category.getProducts().add(product);
//        categoryRepo.save(category);
        productRepo.save(product);
        return "Product added successfully";
    }
//    public List<Product> getByCategoryId(int id)
//    {
//        List<Product> productList= productRepo.(id);
//        return productList;
//    }
    public ProductDto getProduct(Product product)
    {
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setQuantity(product.getQuantity());
        productDto.setCategoryId(productDto.getCategoryId());
        return productDto;
    }
    public List<ProductDto> getAllProducts()
    {
        List<Product> allProducts = productRepo.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : allProducts) {
            productDtos.add(getProduct(product));
        }
        return productDtos;
    }

    public String updateProduct(ProductDto productDto, int productId) throws Exception{
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("Product not found");
        }
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        productRepo.save(product);
        return "Update completed";
    }
    
    public Product findById(Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new Exception("Invalid Product Id: " + productId);
        }
        return optionalProduct.get();
    }


    public boolean outOfStock(AddToCartDto addToCartDto) throws Exception{
        Product product = findById(addToCartDto.getProductId());

        if(product.getQuantity()==0)
            return false;
        else
            return true;
    }

    public boolean checkStockAvailability(AddToCartDto addToCartDto) throws Exception{
        Product product = findById(addToCartDto.getProductId());
        if(product.getQuantity()>addToCartDto.getQuantity())
            return true;
        else
            return false;
    }

    public int getAvailableStock(AddToCartDto addToCartDto) throws Exception{
        Product product = findById(addToCartDto.getProductId());
        return product.getQuantity();
    }
}


