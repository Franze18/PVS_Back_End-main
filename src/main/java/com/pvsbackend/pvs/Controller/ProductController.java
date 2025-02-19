package com.pvsbackend.pvs.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvsbackend.pvs.Model.Product;
import com.pvsbackend.pvs.NotFoundException.ProductNotFoundException;
import com.pvsbackend.pvs.Repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // GET ALL PRODUCTS
    // http://127.0.0.1:8080/products
    @GetMapping("/all")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    // GET ONE PRODUCT
    // http://127.0.0.1:8080/product/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new ProductNotFoundException(id));
    }

    // CREATE ENDPOINTS
    // http://127.0.0.1:8080/product/new
    @PostMapping("/new")
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added. Yey!";
    }

    // UPDATE ENDPOINTS
    // http://127.0.0.1:8080/product/edit/1
    @PutMapping("/edit/{id}")
    public Product updateProduct(@PathVariable Long id,
    @RequestBody Product newProduct){
        return repo.findById(id)
        .map(product ->{
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            product.setUrl(newProduct.getUrl());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
    }

    // DELETE ENDPOINTS
    // http://127.0.0.1:8080/product/delete/1
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        repo.deleteById(id);
        return "A product is deleted!";
    }
}