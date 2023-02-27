package com.salesianas.dto;

import java.io.Serializable;

public class ProfesorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;

	private String dni;

	public ProfesorDto(String nombre, String dni) {

		this.nombre = nombre;
		this.dni = dni;
	}

	public ProfesorDto() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
