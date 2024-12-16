package com.proyectoG.myTech.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoG.myTech.models.Orders;
import com.proyectoG.myTech.services.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    // Get all orders
    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.findAllOrders();
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable("id") Integer id) {
        return ordersService.findOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new order
    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return ordersService.saveOrder(order);
    }

    // Delete order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id) {
        return ordersService.findOrderById(id)
                .map(order -> {
                    ordersService.deleteOrder(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

