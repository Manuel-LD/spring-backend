package com.proyectoG.myTech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectoG.myTech.models.Orders;
import com.proyectoG.myTech.repository.OrdersRepository;

public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;

	//Get
	public List<Orders> findAllOrders(){
		return ordersRepository.findAll();
	}
	public Optional <Orders> findOrderById(Integer id){
		return ordersRepository.findById(id);
	}
	//post
	public Orders saveOrder (Orders orders){
		return ordersRepository.save(orders);
	}
	//put

	//Delete
	public void deleteOrder(Integer id) {
		ordersRepository.deleteById(id);
	}
}
