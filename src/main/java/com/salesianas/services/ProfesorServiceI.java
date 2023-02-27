package com.salesianas.services;

import java.util.List;
import java.util.Optional;

import com.salesianas.dto.ProfesorDto;
import com.salesianas.repositories.Profesor;

public interface ProfesorServiceI  {

	Profesor inscribirProfesor(ProfesorDto profesor);
	Profesor modificarProfesor(Profesor profesor);
	boolean profesorExiste(Long id);
	void eliminaProfesor(Long id);
	Profesor buscarPorNumeroDocente(Long id);
	Optional<Profesor> buscarPorNumeroDocenteOptional(Long id);
	List<Profesor> buscarPorNombre(String nombre);
	List<Profesor> buscarPorDni(String dni);
	List<Profesor> buscarTodos();
}
