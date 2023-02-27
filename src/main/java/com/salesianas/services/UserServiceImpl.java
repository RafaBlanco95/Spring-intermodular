package com.salesianas.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianas.models.User;
import com.salesianas.repositories.UserRepository;

public class UserServiceImpl implements UserServiceI{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User registrarUsuario(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public boolean comprobarUsuario(User user) {
		boolean flag=false;
		
		User nuevo= userRepo.findByUsername(user.getUsername());
		if(user.getPassword().equals(nuevo.getPassword())) {
			flag=true;
		}
		
		return flag;
	}

}
