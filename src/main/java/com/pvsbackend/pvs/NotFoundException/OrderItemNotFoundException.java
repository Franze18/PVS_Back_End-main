package com.pvsbackend.pvs.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long id){
        super("Could not found order item with " + id);
    }
}