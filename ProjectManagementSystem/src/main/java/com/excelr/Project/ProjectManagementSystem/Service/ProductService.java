package com.excelr.Project.ProjectManagementSystem.Service;

import com.excelr.Project.ProjectManagementSystem.Entity.Product;
import com.excelr.Project.ProjectManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> viewAllProducts() {
        return productRepository.findAll();
    }

    public Product viewProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    //public Product updateProductById(Long id, Product updatedProduct) {
        //if (productRepository.existsById(id)) {
            //updatedProduct.setId(id);
            //return productRepository.save(updatedProduct);
        //}
        //return null;
    //}

    public Product updateProduct(Product updatedProduct) {
        // Implement your update logic here
        // You may want to fetch the existing product from the database using its ID
        // Update the fields with the new values
        // Save the updated product
        return productRepository.save(updatedProduct);
    }

    public List<Product> displayProductBasedOnCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> displayProductPriceLessThan5000() {
        return productRepository.findByPriceLessThan(5000);
    }

    public List<Product> displayProductPriceBetween5000And20000() {
        return productRepository.findByPriceBetween(5000, 20000);
    }

    public long countOfAllProducts() {
        return productRepository.count();
    }

    public List<Product> displayProductWhoseRatingGreaterThan4() {
        return productRepository.findByRatingGreaterThan(4.0);
    }

    public List<Product> displayProductWhoseRatingLessThan3() {
        return productRepository.findByRatingLessThan(3.0);
    }

    public List<Product> checkProductStatusIsValidOrNotBasedOnExpiryDate(LocalDate expiryDate) {
        return productRepository.findByExpiryDateAfter(expiryDate);
    }
}



