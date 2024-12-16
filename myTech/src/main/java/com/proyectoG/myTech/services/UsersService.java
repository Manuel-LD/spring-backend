package com.proyectoG.myTech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.proyectoG.myTech.models.Users;
import com.proyectoG.myTech.repository.UsersRepository;

public class UsersService {
	@Autowired
	private UsersRepository usersRepository;

	//Get
	public List<Users> findAllUsers(){
		return usersRepository.findAll();
	}
	public Optional <Users> findUserById(Integer id){
		return usersRepository.findById(id);
	}
	//post
	public Users saveUser (Users users){
		return usersRepository.save(users);
	}
	//put

	//Delete
	public void deleteUser(Integer id) {
		usersRepository.deleteById(id);
	}
}
