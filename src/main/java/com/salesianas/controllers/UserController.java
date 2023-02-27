package com.salesianas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianas.dto.UserDto;
import com.salesianas.models.User;
import com.salesianas.services.UserServiceI;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/usuarios")
public class UserController {

	@Autowired
	private UserServiceI userService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<User>  crearUsuario(final @RequestBody UserDto user) {
		try {
			User nuevo = new User();
			nuevo.setUsername(user.getUsername());
			nuevo.setEmail(user.getEmail());
			nuevo.setPassword(user.getPassword());
			userService.registrarUsuario(nuevo);
			return new ResponseEntity<> (nuevo, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<> (new User(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public boolean comprobarUsuario(final @RequestBody UserDto user) {
		User nuevo = new User();
		nuevo.setUsername(user.getUsername());
		nuevo.setEmail(user.getEmail());
		nuevo.setPassword(user.getPassword());
		return userService.comprobarUsuario(nuevo);
		
	}
}
