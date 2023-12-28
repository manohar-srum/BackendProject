package com.excelr.Project.ProductManagementSystem.Bean;

import com.excelr.Project.ProductManagementSystem.Product;
import com.excelr.Project.ProductManagementSystem.Service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public ProductService productService() {
        return new ProductService() {
            @Override
            public void addProduct(Product product) {

            }

            @Override
            public List<Product> viewAllProducts() {
                return null;
            }

            @Override
            public Product viewProductById(Long id) {
                return null;
            }

            @Override
            public void updateProductById(Long id, Product updatedProduct) {

            }

            @Override
            public List<Product> displayProductBasedOnCategory(String category) {
                return null;
            }

            @Override
            public List<Product> displayProductPriceLessThan5000() {
                return null;
            }

            @Override
            public List<Product> displayProductPriceBetween5000And20000() {
                return null;
            }

            @Override
            public int countOfAllProducts() {
                return 0;
            }

            @Override
            public boolean checkProductStatusIsValidOrNot() {
                return false;
            }

            @Override
            public List<Product> displayProductWhoseRatingLessThan(double rating) {
                return null;
            }
        };
    }
}

