package com.salesianas.repositories;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlumnoControlId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "C_ALUMNO_ID")
	private Long alumnoId;

	@Column(name = "C_CONTROL_NUMERO")
	private Long controlId;

	public AlumnoControlId(Long alumnoId, Long controlId) {
		this.alumnoId = alumnoId;
		this.controlId = controlId;
	}

	public AlumnoControlId() {
	
	}

	public Long getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}

	public Long getControlId() {
		return controlId;
	}

	public void setControlId(Long controlId) {
		this.controlId = controlId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(alumnoId, controlId);
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		AlumnoControlId that = (AlumnoControlId) o;
		return Objects.equals(alumnoId, that.alumnoId) && Objects.equals(controlId, that.controlId);
	}
	
}
