package com.proyectoG.myTech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoG.myTech.models.Shipments;
import com.proyectoG.myTech.repository.ShipmentsRepository;

@Service
public class ShipmentsService {
	@Autowired
	private ShipmentsRepository shipmentsRepository;

	//Get
	public List<Shipments> findAllShipments(){
		return shipmentsRepository.findAll();
	}
	public Optional <Shipments> findShipmentById(Integer id){
		return shipmentsRepository.findById(id);
	}
	//post
	public Shipments saveShipment (Shipments shipments){
		return shipmentsRepository.save(shipments);
	}
	//put

	//Delete
	public void deleteShipment(Integer id) {
		shipmentsRepository.deleteById(id);
	}
}
