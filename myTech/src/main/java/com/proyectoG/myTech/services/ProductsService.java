package com.proyectoG.myTech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoG.myTech.models.Products;
import com.proyectoG.myTech.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository productsRepository;

	//Get
	public List<Products> findAllProducts(){
		return productsRepository.findAll();
	}
	public Optional <Products> findProductById(Integer id){
		return productsRepository.findById(id);
	}
	//post
	public Products saveProduct (Products products){
		return productsRepository.save(products);
	}
	//put

	//Delete
	public void deleteProduct(Integer id) {
		productsRepository.deleteById(id);
	}
}
