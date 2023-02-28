package com.salesianas.exception;

public class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
		super("No se ha encontrado un usuario con id "+ id);
	}
}