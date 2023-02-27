package com.salesianas.exception;

public class ControlNotFoundException  extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public ControlNotFoundException(Long id) {
		super("No se ha encontrado un examen con el identificador "+ id);
	}
}