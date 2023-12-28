package com.excelr.Project.ProductManagementSystem.Repository;

// ProductRepository.java
import com.excelr.Project.ProductManagementSystem.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByRatingGreaterThan(double rating);

    List<Product> getAllProducts();
    List<Product> getProductsWhoseRatingIsLessThanThree();

    List<Product> findAll();
    List<Product> findProductsByRatingLessThan(double rating);
}

