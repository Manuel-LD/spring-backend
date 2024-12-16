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

import com.proyectoG.myTech.models.Messages;
import com.proyectoG.myTech.services.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    
    @Autowired
    private MessageService messagesService;

    // Get all messages
    @GetMapping
    public List<Messages> getAllMessages() {
        return messagesService.findAllMessages();
    }

    // Get message by ID
    @GetMapping("/{id}")
    public ResponseEntity<Messages> getMessageById(@PathVariable("id") Integer id) {
        return messagesService.findMessageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new message
    @PostMapping
    public Messages createMessage(@RequestBody Messages message) {
        return messagesService.saveMessage(message);
    }

    // Delete message by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable("id") Integer id) {
        return messagesService.findMessageById(id)
                .map(message -> {
                    messagesService.deleteMessage(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
