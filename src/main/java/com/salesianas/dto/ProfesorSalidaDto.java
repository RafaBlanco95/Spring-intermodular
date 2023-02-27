package com.salesianas.dto;

import java.util.List;

public class ProfesorSalidaDto {

	private Long numeroDocente;

	private String nombre;

	private String dni;

	private List<PracticaProfesorDto> practicas;

	public ProfesorSalidaDto() {

	}

	public ProfesorSalidaDto(Long numeroDocente, String nombre, String dni, List<PracticaProfesorDto> practicas) {

		this.numeroDocente = numeroDocente;
		this.nombre = nombre;
		this.dni = dni;
		this.practicas = practicas;
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

	public List<PracticaProfesorDto> getPracticas() {
		return practicas;
	}

	public void setPracticas(List<PracticaProfesorDto> practicas) {
		this.practicas = practicas;
	}

}
