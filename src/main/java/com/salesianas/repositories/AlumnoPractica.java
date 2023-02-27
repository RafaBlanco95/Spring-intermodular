package com.salesianas.repositories;



import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "T_ALUMNO_PRACTICA")
public class AlumnoPractica {

	
		
		@EmbeddedId
	    private AlumnoPracticaId id;
	 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("alumnoId")
	    private Alumno alumno;
	 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("practicaId")
	    private Practica practica;
	 
	    @Column(name = "FECHA")
	    private LocalDate fecha;
	    
	    @Column(name = "NOTA")
	    private Double nota;

		public AlumnoPractica(AlumnoPracticaId id, Alumno alumno, Practica practica, LocalDate createdOn, Double nota) {
			this.id = id;
			this.alumno = alumno;
			this.practica = practica;
			this.fecha = createdOn;
			this.nota = nota;
		}
		
		public AlumnoPractica(Alumno alumno, Practica practica) {
			this.alumno=alumno;
			this.practica=practica;
			this.id=new AlumnoPracticaId(alumno.getMatricula(), practica.getCodigoPractica());
		}

		public AlumnoPractica() {
			
		}

		
		public AlumnoPracticaId getId() {
			return id;
		}

		public void setId(AlumnoPracticaId id) {
			this.id = id;
		}

		public Alumno getAlumno() {
			return alumno;
		}

		public void setAlumno(Alumno alumno) {
			this.alumno = alumno;
		}

		public Practica getPractica() {
			return practica;
		}

		public void setPractica(Practica practica) {
			this.practica = practica;
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

		@Override
		public int hashCode() {
			return Objects.hash(alumno, practica);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			
			AlumnoPractica that = (AlumnoPractica) o;
			return Objects.equals(alumno, that.alumno) && Objects.equals(practica, that.practica);
		}

		
		
	    
	    
}
