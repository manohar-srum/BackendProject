package com.excelr.Project.ProductManagementSystem.Service;

// ProductService.java
import com.excelr.Project.ProductManagementSystem.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<Product> viewAllProducts();
    Product viewProductById(Long id);
    void updateProductById(Long id, Product updatedProduct);
    List<Product> displayProductBasedOnCategory(String category);
    List<Product> displayProductPriceLessThan5000();
    List<Product> displayProductPriceBetween5000And20000();
    int countOfAllProducts();

    boolean checkProductStatusIsValidOrNot();

    List<Product> displayProductWhoseRatingLessThan(double rating);
}

