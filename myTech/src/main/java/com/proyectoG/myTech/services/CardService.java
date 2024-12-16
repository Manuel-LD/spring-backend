package com.proyectoG.myTech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoG.myTech.models.Cards;
import com.proyectoG.myTech.repository.CardRepository;

@Service
public class CardService {
@Autowired
private CardRepository cardRepository;

//Get
public List<Cards> findAllCards(){
	return cardRepository.findAll();
}
public Optional <Cards> findCardById(Integer id){
	return cardRepository.findById(id);
}
//post
public Cards saveCard (Cards cards){
	return cardRepository.save(cards);
}
//put

//Delete
public void deleteCard(Integer id) {
	cardRepository.deleteById(id);
}
}

