package com.salesianas.dto;

import java.time.LocalDate;

public class AlumnoCompletoDto {

	private Long matricula;
	
	private String nombre;
	
	private String grupo;
	
	private LocalDate fecha;
	
	private double nota;
	
	

	public AlumnoCompletoDto(Long matricula, String nombre, String grupo, LocalDate fecha, double nota) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.grupo = grupo;
		this.fecha = fecha;
		this.nota = nota;
	}
	
	

	public AlumnoCompletoDto() {
		
	}



	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
}
