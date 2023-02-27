package com.salesianas.dto;

import java.io.Serializable;

public class PracticaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private int dificultad;

	public PracticaDto(String titulo, int dificultad) {
		this.titulo = titulo;
		this.dificultad = dificultad;
	}

	public PracticaDto() {

	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

}
