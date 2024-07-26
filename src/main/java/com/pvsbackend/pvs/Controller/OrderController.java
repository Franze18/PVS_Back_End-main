package com.pvsbackend.pvs.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvsbackend.pvs.Model.Order;
import com.pvsbackend.pvs.NotFoundException.OrderNotFoundException;
import com.pvsbackend.pvs.Repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    
    OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    // GET ALL ORDERS
    // http://127.0.0.1:8080/orders
    @GetMapping("/all")
    public List<Order> getOrders(){
        return repo.findAll();
    }

    // GET ONE ORDER
    // http://127.0.0.1:8080/order/1
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderNotFoundException(id));
    }

    // CREATE ENDPOINTS
    // http://127.0.0.1:8080/order/new
    @PostMapping("/new")
    public String addOrder(@RequestBody Order newOrder){
        repo.save(newOrder);
        return "A new order is added. Yey!";
    }

    // DELETE ENDPOINTS
    // http://127.0.0.1:8080/order/delete/1
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        repo.deleteById(id);
        return "A order is deleted!";
    }
}