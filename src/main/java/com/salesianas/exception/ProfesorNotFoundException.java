package com.salesianas.exception;

public class ProfesorNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProfesorNotFoundException(Long id) {
		super("No se ha encontrado un profesor con el número de docente "+ id);
	}
}
