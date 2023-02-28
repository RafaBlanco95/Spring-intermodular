package com.salesianas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianas.dto.UserDto;
import com.salesianas.dto.UserIdDto;
import com.salesianas.exception.UserNotFoundException;
import com.salesianas.repositories.User;
import com.salesianas.services.UserServiceI;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class UserController {

	@Autowired
	private UserServiceI userService;

	@PostMapping("/nuevo")
	public ResponseEntity<User> crearUsuario(final @RequestBody UserDto user) {
		try {
			User nuevo = new User();
			nuevo.setUsername(user.getUsername());
			nuevo.setEmail(user.getEmail());
			nuevo.setPassword(user.getPassword());

			return new ResponseEntity<>(userService.registrarUsuario(nuevo), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/iniciarSesion")
	public ResponseEntity<User> iniciarSesion(final @RequestBody UserIdDto dto){
		
		try{
			User user= userService.buscarPorNombreDeUsuario(dto.getUsername());
		
			if(!(user.getPassword().equals(dto.getPassword()))){
				user=new User();
			}
		
			return new ResponseEntity<> (user, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<> (new User(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar/{id}")
	public User modificarUsuario(final @RequestBody UserDto dto,final @PathVariable Long id) {

		return userService.buscarPorIdOptional(id)
				.map(user->{
					 user.setUsername(dto.getUsername());
					 user.setPassword(dto.getPassword());
					 user.setEmail(dto.getEmail());
					 return userService.modificarUsuario(user);
				}).orElseThrow(()->new UserNotFoundException(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> buscarPorId(final @PathVariable Long id) {
		try {
			
		User user=userService.buscarPorIdOptional(id).get();
		UserDto userDto= new UserDto();
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());
		
		return new ResponseEntity<> ( userDto, HttpStatus.OK);
	} catch(Exception e) {
		return new ResponseEntity<> (new UserDto(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	}
}
