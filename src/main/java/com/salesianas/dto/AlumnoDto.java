package com.salesianas.dto;

import java.io.Serializable;

public class AlumnoDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombre;

	private String grupo;
	
	

	public AlumnoDto(String nombre, String grupo) {
		this.nombre = nombre;
		this.grupo = grupo;
	}
	
	

	public AlumnoDto() {
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
}
