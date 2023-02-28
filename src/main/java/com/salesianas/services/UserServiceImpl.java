package com.salesianas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianas.repositories.User;
import com.salesianas.repositories.UserRepository;

@Service
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

	@Override
	public User buscarPorNombreDeUsuario(String nombreDeUsuario) {
		
		return userRepo.findByUsername(nombreDeUsuario);
	}

	@Override
	public User modificarUsuario(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public Optional<User> buscarPorIdOptional(Long id) {
		
		return userRepo.findById(id);
	}

}
