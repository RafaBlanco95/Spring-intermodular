package com.salesianas.dto;

import java.util.List;

public class PracticaDocenteDto {

	private String titulo;
	
	private int dificultad;
	
	private List<ProfesorPracticaDto> profesores;
	
	

	public PracticaDocenteDto() {
		
	}

	public PracticaDocenteDto(String titulo, int dificultad, List<ProfesorPracticaDto> profesores) {
		
		this.titulo = titulo;
		this.dificultad = dificultad;
		this.profesores = profesores;
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

	public List<ProfesorPracticaDto> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<ProfesorPracticaDto> profesores) {
		this.profesores = profesores;
	}
	
	
}
