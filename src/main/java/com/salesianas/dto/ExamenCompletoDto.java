package com.salesianas.dto;

import java.time.LocalDate;

public class ExamenCompletoDto {

	private Long numeroControl;

	private String nombre;

	private int preguntas;

	private LocalDate fecha;

	private double nota;

	public ExamenCompletoDto() {

	}

	public ExamenCompletoDto(Long numeroControl, String nombre, int preguntas, LocalDate fecha, double nota) {
		this.numeroControl = numeroControl;
		this.nombre = nombre;
		this.preguntas = preguntas;
		this.fecha = fecha;
		this.nota = nota;
	}

	public Long getNumeroControl() {
		return numeroControl;
	}

	public void setNumeroControl(Long numeroControl) {
		this.numeroControl = numeroControl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(int preguntas) {
		this.preguntas = preguntas;
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
