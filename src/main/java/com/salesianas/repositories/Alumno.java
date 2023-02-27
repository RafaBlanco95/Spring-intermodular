package com.salesianas.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_ALUMNO")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ALUMNO_MATRICULA", nullable = false)
	private Long matricula;

	@Column(name = "C_ALUMNO_NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "C_ALUMNO_GRUPO", nullable = false)
	private String grupo;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "alumno")
	private List<AlumnoControl> controles;

	@JsonIgnore
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
	private List<AlumnoPractica> practicas = new ArrayList<>();

	public void asignarPractica(Practica practica) {
		AlumnoPractica alumnoPractica = new AlumnoPractica(this, practica);
		practicas.add(alumnoPractica);
		practica.getAlumnos().add(alumnoPractica);
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

	public List<AlumnoPractica> getPracticas() {
		return practicas;
	}

	public void setPracticas(List<AlumnoPractica> practicas) {
		this.practicas = practicas;
	}

	public List<AlumnoControl> getControles() {
		return controles;
	}

	public void setControles(List<AlumnoControl> controles) {
		this.controles = controles;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Alumno))
			return false;
		return matricula != null && matricula.equals(((Alumno) o).getMatricula());
	}

}
