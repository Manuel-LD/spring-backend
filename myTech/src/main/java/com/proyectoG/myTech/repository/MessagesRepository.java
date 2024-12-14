package com.proyectoG.myTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoG.myTech.models.Messages;

@Repository 
public interface MessagesRepository extends JpaRepository<Messages, Integer> {

}