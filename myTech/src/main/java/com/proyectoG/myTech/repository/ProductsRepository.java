package com.proyectoG.myTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoG.myTech.models.Products;

@Repository 
public interface ProductsRepository extends JpaRepository<Products, Integer> {

}