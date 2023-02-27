package com.salesianas.dto;

import java.time.LocalDate;
import java.util.List;

public class ControlSalidaDto {

	private Long numeroControl;
	
	private int preguntas;
	
	private String nombre;
	
	private LocalDate fecha;
	
	private List<AlumnoCompletoControlDto> alumnos;
	
	
	

	public ControlSalidaDto() {
		
	}

	public ControlSalidaDto(Long numeroControl, int preguntas, String nombre, LocalDate fecha,
			List<AlumnoCompletoControlDto> alumnos) {
	
		this.numeroControl = numeroControl;
		this.preguntas = preguntas;
		this.nombre = nombre;
		this.fecha = fecha;
		this.alumnos = alumnos;
	}

	public Long getNumeroControl() {
		return numeroControl;
	}

	public void setNumeroControl(Long numeroControl) {
		this.numeroControl = numeroControl;
	}

	public int getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(int preguntas) {
		this.preguntas = preguntas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<AlumnoCompletoControlDto> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoCompletoControlDto> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
