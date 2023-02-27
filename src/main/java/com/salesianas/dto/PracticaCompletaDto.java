package com.salesianas.dto;

import java.time.LocalDate;

public class PracticaCompletaDto {

	private Long codigoPractica;
	
	private String titulo;

	private int dificultad;
	
	private LocalDate fecha;
	
	private double nota;
	
	
	

	public PracticaCompletaDto() {
		
	}

	public PracticaCompletaDto(Long codigoPractica, String titulo, int dificultad, LocalDate fecha, double nota) {
		
		this.codigoPractica = codigoPractica;
		this.titulo = titulo;
		this.dificultad = dificultad;
		this.fecha = fecha;
		this.nota = nota;
	}

	public Long getCodigoPractica() {
		return codigoPractica;
	}

	public void setCodigoPractica(Long codigoPractica) {
		this.codigoPractica = codigoPractica;
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
