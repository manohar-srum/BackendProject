package com.excelr.Project.ProductManagementSystem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.util.Date;
@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private  double Price;
    private String  Category;
    private String Description;
    private int Quantity;
    private double Rating;
    private Date ExpiryDate;




    // getters and setters

    // constructor

}
