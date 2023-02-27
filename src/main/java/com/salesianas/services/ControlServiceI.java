package com.salesianas.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.salesianas.dto.ControlDto;
import com.salesianas.repositories.Control;

public interface ControlServiceI {

	Control crearControl(ControlDto control);
	Control modificarControl(Control control);
	boolean controlExiste(Long id);
	void eliminarControl(Long id);
	Control buscarPorId(Long id);
	Optional<Control> buscarPorNumeroControlOptional(Long numeroControl);
	List<Control> buscarPorPreguntas(int preguntas);
	List<Control> buscarPorFecha(LocalDate fecha);
	List<Control> buscarPorNombre(String nombre);
	List<Control> buscarTodos();
	
	
}
