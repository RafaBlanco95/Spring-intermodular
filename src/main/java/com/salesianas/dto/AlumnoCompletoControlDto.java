package com.salesianas.dto;



public class AlumnoCompletoControlDto {
	
	private Long matricula;
	
	private String nombre;
	
	private String grupo;
	
	private double nota;
	
	

	public AlumnoCompletoControlDto(Long matricula, String nombre, String grupo,  double nota) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.grupo = grupo;
		this.nota = nota;
	}
	
	

	public AlumnoCompletoControlDto() {
		
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

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
}
