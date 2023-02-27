package com.salesianas.exception;

public class PracticaNotFoundException  extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public PracticaNotFoundException(Long id) {
		super("No se ha encontrado una práctica con el número de práctica "+ id);
	}

}
