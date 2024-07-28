package com.pvsbackend.pvs.Model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    private @Id
    @GeneratedValue Long id;
    private String productName;
    private String description;
    private double price;
    private String url;
    private String category;
    
    Product(){}

    public Product(String productName, String description, double price, String url, String category) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.url = url;
        this.category = category;
    }

    // Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    
    public String getUrl() {
        return url;
    }
}