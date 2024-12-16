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

import com.proyectoG.myTech.models.Products;
import com.proyectoG.myTech.services.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    // Get all products
    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.findAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable("id") Integer id) {
        return productsService.findProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new product
    @PostMapping
    public Products createProduct(@RequestBody Products product) {
        return productsService.saveProduct(product);
    }

    // Delete product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
        return productsService.findProductById(id)
                .map(product -> {
                    productsService.deleteProduct(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

