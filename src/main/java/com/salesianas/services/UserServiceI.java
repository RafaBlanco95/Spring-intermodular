package com.salesianas.services;

import com.salesianas.models.User;

public interface UserServiceI {

	
	User registrarUsuario(User user);
	boolean comprobarUsuario(User user);
}
