package com.salesianas.repositories;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "T_ALUMNO_CONTROL")
public class AlumnoControl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
    private AlumnoControlId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alumnoId")
    private Alumno alumno;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("controlId")
    private Control control;
    
    @Column(name = "NOTA")
    private Double nota;

    
    
	public AlumnoControl(AlumnoControlId id, Alumno alumno, Control control, Double nota) {
		this.id = id;
		this.alumno = alumno;
		this.control = control;
		this.nota = nota;
	}
	
	public AlumnoControl(Alumno alumno, Control control) {
		this.alumno=alumno;
		this.control=control;
		this.id= new AlumnoControlId(alumno.getMatricula(),control.getNumeroControl());
	}

	public AlumnoControl() {
		
	}



	public AlumnoControlId getId() {
		return id;
	}

	public void setId(AlumnoControlId id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
    
    
}
