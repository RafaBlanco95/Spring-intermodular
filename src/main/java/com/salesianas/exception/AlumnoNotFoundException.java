package com.salesianas.exception;

public class AlumnoNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public AlumnoNotFoundException(Long id) {
		super("No se ha encontrado un alumno con el número de matrícula "+ id);
	}
}
