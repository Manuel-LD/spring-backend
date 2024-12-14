package com.proyectoG.myTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoG.myTech.models.Cards;

@Repository 
public interface CardRepository extends JpaRepository<Cards, Integer> {

}