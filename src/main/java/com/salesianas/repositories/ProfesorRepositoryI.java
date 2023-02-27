package com.salesianas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepositoryI extends JpaRepository<Profesor, Long>{

	Profesor findByNumeroDocente(final Long numeroDocente);
	
	List<Profesor> findByNombre(final String nombre);
	
	List<Profesor> findByDni(final String dni);
}
