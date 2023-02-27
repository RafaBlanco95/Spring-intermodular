package com.salesianas.dto;

public class ProfesorPracticaDto {

	private Long numeroDocente;

	private String nombre;

	private String dni;

	public ProfesorPracticaDto() {
	}

	public ProfesorPracticaDto(Long numeroDocente, String nombre, String dni) {
		this.numeroDocente = numeroDocente;
		this.nombre = nombre;
		this.dni = dni;
	}

	public Long getNumeroDocente() {
		return numeroDocente;
	}

	public void setNumeroDocente(Long numeroDocente) {
		this.numeroDocente = numeroDocente;
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
