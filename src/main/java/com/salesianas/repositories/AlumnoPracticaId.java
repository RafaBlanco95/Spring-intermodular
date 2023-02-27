package com.salesianas.repositories;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlumnoPracticaId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "alumno")
	private Long alumnoId;

	@Column(name = "practica")
	private Long practicaId;
	
	

	public AlumnoPracticaId() {
	
	}

	public AlumnoPracticaId(Long alumnoId, Long practicaId) {
		
		this.alumnoId = alumnoId;
		this.practicaId = practicaId;
	}

	public Long getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}

	public Long getPracticaId() {
		return practicaId;
	}

	public void setPracticaId(Long practicaId) {
		this.practicaId = practicaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumnoId, practicaId);
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		AlumnoPracticaId that = (AlumnoPracticaId) o;
		return Objects.equals(alumnoId, that.alumnoId) && Objects.equals(practicaId, that.practicaId);
	}

}
