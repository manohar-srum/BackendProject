package com.excelr.Project.ProjectManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

//import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product2")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
     @Column(name = "name")
    private String name;
     @Column(name = "price")
    private double price;

    private String category;

    private String description;

    private Integer quantity;

    private double rating;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expiryDate;

    public Product() {

    }

    public Product(Long id, String name, double price, String category, String description, int quantity, double rating, Date expiryDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.rating = rating;
        this.expiryDate = expiryDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", rating=" + rating +
                ", expiryDate=" + expiryDate +
                '}';
    }

}

