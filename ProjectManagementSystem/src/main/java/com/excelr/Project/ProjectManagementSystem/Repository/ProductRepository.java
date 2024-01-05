package com.excelr.Project.ProjectManagementSystem.Repository;

import com.excelr.Project.ProjectManagementSystem.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);

    List<Product> findByPriceLessThan(double price);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByRatingGreaterThan(double rating);

    List<Product> findByRatingLessThan(double rating);

    List<Product> findByExpiryDateAfter(LocalDate expiryDate);
}

