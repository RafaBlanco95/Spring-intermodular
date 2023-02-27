package com.salesianas.services;

import java.util.List;
import java.util.Optional;

import com.salesianas.dto.PracticaDto;
import com.salesianas.repositories.Practica;

public interface PracticaServiceI {
	
	Practica crearPractica(PracticaDto practica);
	Practica modificarPractica(Practica practica);
	boolean practicaExiste(Long id);
	void eliminarPractica(Long id);
	Practica buscarPorId(Long id);
	Optional<Practica> buscarPorCodigoPracticaOptional(Long codigoPractica);
	List<Practica> buscarPorTitulo(String titulo);
	List<Practica> buscarPorDificultad(int dificultad);
	List<Practica> buscarTodos();

}
