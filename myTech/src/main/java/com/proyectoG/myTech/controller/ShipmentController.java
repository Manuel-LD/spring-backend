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

import com.proyectoG.myTech.models.Shipments;
import com.proyectoG.myTech.services.ShipmentsService;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentsService shipmentsService;

    // Get all shipments
    @GetMapping
    public List<Shipments> getAllShipments() {
        return shipmentsService.findAllShipments();
    }

    // Get shipment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Shipments> getShipmentById(@PathVariable("id") Integer id) {
        return shipmentsService.findShipmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new shipment
    @PostMapping
    public Shipments createShipment(@RequestBody Shipments shipment) {
        return shipmentsService.saveShipment(shipment);
    }

    // Delete shipment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable("id") Integer id) {
        return shipmentsService.findShipmentById(id)
                .map(shipment -> {
                    shipmentsService.deleteShipment(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

