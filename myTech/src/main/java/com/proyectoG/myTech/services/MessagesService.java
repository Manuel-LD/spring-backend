package com.proyectoG.myTech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.proyectoG.myTech.models.Messages;

import com.proyectoG.myTech.repository.MessagesRepository;

public class MessagesService {
	@Autowired
	private MessagesRepository messagesRepository;

	//Get
	public List<Messages> findAllMessages(){
		return messagesRepository.findAll();
	}
	public Optional <Messages> findMessageById(Integer id){
		return messagesRepository.findById(id);
	}
	//post
	public Messages saveMessage (Messages messages){
		return messagesRepository.save(messages);
	}
	//put

	//Delete
	public void deleteMessage(Integer id) {
		messagesRepository.deleteById(id);
	}
}
