package com.proyectoG.myTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoG.myTech.models.Shipments;

@Repository 
public interface ShipmentsRepository extends JpaRepository<Shipments, Integer> {

}