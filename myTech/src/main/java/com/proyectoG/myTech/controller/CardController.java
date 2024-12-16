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

import com.proyectoG.myTech.models.Cards;
import com.proyectoG.myTech.services.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {
	@Autowired
	private CardService cardService;
	
	//get
		@GetMapping
		public List<Cards> getAllCards(){
			return cardService.findAllCards();
		}
			
		@GetMapping("/{id}")
		public ResponseEntity<Cards> getCardById(@PathVariable("id")Integer id){
		return cardService.findCardById(id)	
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		}
		
		//post
		@PostMapping
		public Cards createCard(@RequestBody Cards card) {
			return cardService.saveCard(card);
		}
		//put
		
		//delete
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Integer id){
			return cardService.findCardById(id) //se puede terminar, se puede usar mapentity, or else
					.map(author -> {
						cardService.deleteCard(id);
						return ResponseEntity.ok().<Void>build();
					})
					.orElse(ResponseEntity.notFound().build());
		}
	
	
	
}
