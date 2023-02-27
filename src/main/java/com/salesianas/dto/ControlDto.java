package com.salesianas.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ControlDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int preguntas;

	private LocalDate fecha;

	private String nombre;

	public ControlDto(int preguntas, LocalDate fecha, String nombre) {
		this.preguntas = preguntas;
		this.fecha = fecha;
		this.nombre = nombre;
	}

	public ControlDto() {

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
