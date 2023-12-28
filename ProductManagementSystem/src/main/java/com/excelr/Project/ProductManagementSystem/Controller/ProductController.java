package com.excelr.Project.ProductManagementSystem.Controller;

// ProductController.java
import com.excelr.Project.ProductManagementSystem.Product;
import com.excelr.Project.ProductManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping
    public List<Product> viewAllProducts() {
        return productService.viewAllProducts();
    }

    @GetMapping("/{id}")
    public Product viewProductById(@PathVariable Long id) {
        return productService.viewProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProductById(@PathVariable Long id, @RequestBody Product updatedProduct) {
        productService.updateProductById(id, updatedProduct);
    }

    @GetMapping("/category/{category}")
    public List<Product> displayProductBasedOnCategory(@PathVariable String category) {
        return productService.displayProductBasedOnCategory(category);
    }

    @GetMapping("/price-less-than-5000")
    public List<Product> displayProductPriceLessThan5000() {
        return productService.displayProductPriceLessThan5000();
    }

    @GetMapping("/price-between-5000-and-20000")
    public List<Product> displayProductPriceBetween5000And20000() {
        return productService.displayProductPriceBetween5000And20000();
    }

    @GetMapping("/count")
    public int countOfAllProducts() {
        return productService.countOfAllProducts();
    }


    @GetMapping("/checkProductStatus")
    public String checkProductStatus(@RequestParam Date expiryDate) {
        productService.checkProductStatusIsValidOrNot();
        return "Product is valid!";
    }
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/rating-less-than")
    public List<Product> displayProductsWhoseRatingLessThan(@RequestParam double rating) {
        return productService.displayProductWhoseRatingLessThan(rating);
    }
}

