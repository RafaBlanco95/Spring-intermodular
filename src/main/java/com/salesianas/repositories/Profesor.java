package com.salesianas.repositories;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_PROFESOR")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_NUMERO_DOCENTE_PROFESOR", nullable = false)
	private Long numeroDocente;
	@Column(name = "C_NOMBRE_PROFESOR")
	private String nombre;
	
	@Column(name = "C_DNI_PROFESOR")
	private String dni;
	
	@ManyToMany(mappedBy="profesores", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Practica> practicas;
	
	
	public Profesor(Long numeroDocente, String nombre, String dni, List<Practica> practicas) {
		
		this.numeroDocente = numeroDocente;
		this.nombre = nombre;
		this.dni = dni;
		this.practicas = practicas;
	}

	public Profesor() {
		
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

	public List<Practica> getPracticas() {
		return practicas;
	}

	public void setPracticas(List<Practica> practicas) {
		this.practicas = practicas;
	}
	
	
	
	
}
