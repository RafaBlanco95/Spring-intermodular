package com.salesianas.dto;

import java.time.LocalDate;

public class AlumnoPracticaDto {
 
 
    private LocalDate fecha;
    
   
    private Double nota;

    
    

	public AlumnoPracticaDto() {
		
	}


	public AlumnoPracticaDto(LocalDate fecha, Double nota) {
		
		this.fecha = fecha;
		this.nota = nota;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public Double getNota() {
		return nota;
	}


	public void setNota(Double nota) {
		this.nota = nota;
	}
    
    
}
