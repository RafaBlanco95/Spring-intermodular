package com.salesianas.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_CONTROL")
public class Control implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_CONTROL_NUMERO", nullable = false)
	private Long numeroControl;

	@Column(name = "C_CONTROL_PREGUNTAS", nullable = false)
	private int preguntas;

	@Column(name = "C_CONTROL_FECHA", nullable = false)
	private LocalDate fecha;

	@Column(name = "C_CONTROL_NOMBRE", nullable = false)
	private String nombre;

	@JsonIgnore
	@OneToMany(mappedBy = "control", cascade = CascadeType.ALL)
	private List<AlumnoControl> alumnos = new ArrayList<>();

	public Control() {

	}

	public Control(Long numeroControl, int preguntas, LocalDate fecha, List<AlumnoControl> alumnos, String nombre) {
		this.numeroControl = numeroControl;
		this.preguntas = preguntas;
		this.fecha = fecha;
		this.alumnos = alumnos;
		this.nombre = nombre;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<AlumnoControl> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoControl> alumnos) {
		this.alumnos = alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
