package com.salesianas.services;

import java.util.Optional;

import com.salesianas.repositories.User;

public interface UserServiceI {

	Optional<User> buscarPorIdOptional(Long id);
	User modificarUsuario(User user);
	User buscarPorNombreDeUsuario(String nombreDeUsuario);
	User registrarUsuario(User user);
	boolean comprobarUsuario(User user);
}
