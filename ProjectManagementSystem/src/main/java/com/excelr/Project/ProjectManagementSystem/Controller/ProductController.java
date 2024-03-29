package com.excelr.Project.ProjectManagementSystem.Controller;

import com.excelr.Project.ProjectManagementSystem.Entity.Product;
import com.excelr.Project.ProjectManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")    
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }



    @GetMapping("/all")
    public List<Product> viewAllProducts() {
        return productService.viewAllProducts();
    }

    @GetMapping("/{id}")
    public Product viewProductById(@PathVariable Long id) {
        return productService.viewProductById(id);
    }

    //@PutMapping("/update/{id}")

    //public Product updateProductById(@PathVariable Long id, @RequestBody Product updatedProduct,@PathVariable Integer Id) {
        //return productService.updateProductById(id, updatedProduct);
    //}

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product updatedProduct) {
        return productService.updateProduct(updatedProduct);
    }

    @GetMapping("/category/{category}")
    public List<Product> displayProductBasedOnCategory(@PathVariable String category) {
        return productService.displayProductBasedOnCategory(category);
    }

    @GetMapping("/price/less-than-5000")
    public List<Product> displayProductPriceLessThan5000() {
        return productService.displayProductPriceLessThan5000();
    }

    @GetMapping("/price/between-5000-and-20000")
    public List<Product> displayProductPriceBetween5000And20000() {
        return productService.displayProductPriceBetween5000And20000();
    }

    @GetMapping("/count")
    public long countOfAllProducts() {
        return productService.countOfAllProducts();
    }

    @GetMapping("/rating/greater-than-4")
    public List<Product> displayProductWhoseRatingGreaterThan4() {
        return productService.displayProductWhoseRatingGreaterThan4();
    }

    @GetMapping("/rating/less-than-3")
    public List<Product> displayProductWhoseRatingLessThan3() {
        return productService.displayProductWhoseRatingLessThan3();
    }

    @GetMapping("/expiry-date/{expiryDate}")
    public List<Product> checkProductStatusIsValidOrNotBasedOnExpiryDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expiryDate) {
        return productService.checkProductStatusIsValidOrNotBasedOnExpiryDate(expiryDate);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}
