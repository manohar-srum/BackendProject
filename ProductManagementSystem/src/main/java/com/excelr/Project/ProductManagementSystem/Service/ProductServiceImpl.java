package com.excelr.Project.ProductManagementSystem.Service;

import com.excelr.Project.ProductManagementSystem.ExceptionHandler.ProductExpiredException;
import com.excelr.Project.ProductManagementSystem.Product;
import com.excelr.Project.ProductManagementSystem.Repository.ProductRepository;
import com.excelr.Project.ProductManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
abstract class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> viewAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product viewProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public void updateProductById(Long id, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            // Update fields of existingProduct with values from updatedProduct
            // ...
            productRepository.save(existingProduct);
        }
    }

    @Override
    public List<Product> displayProductBasedOnCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> displayProductPriceLessThan5000() {
        return productRepository.findByPriceLessThan(5000.0);
    }

    @Override
    public List<Product> displayProductPriceBetween5000And20000() {
        return productRepository.findByPriceBetween(5000.0, 20000.0);
    }

    @Override
    public int countOfAllProducts() {
        return (int) productRepository.count();
    }

    @Override
    public boolean checkProductStatusIsValidOrNot() {
        return false;
    }

    public List<Product> getProductsByRatingGreaterThan(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }

        return productRepository.findByRatingGreaterThan(rating);
    }
    public boolean checkProductStatusIsValidOrNot(Date expiryDate) throws ProductExpiredException {
        Date currentDate = new Date();
        if (expiryDate != null && expiryDate.before(currentDate)) {
            throw new ProductExpiredException("Product has expired!");
        }
        return true;
    }
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> displayProductWhoseRatingLessThan(double rating) {
        return productRepository.findProductsByRatingLessThan(rating);
    }

        }






