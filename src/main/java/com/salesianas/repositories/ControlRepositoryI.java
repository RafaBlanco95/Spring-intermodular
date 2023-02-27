package com.salesianas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlRepositoryI extends JpaRepository<Control, Long>{

	List<Control> findByPreguntas(final int preguntas);
	List<Control> findByFecha(final String fecha);
	List<Control> findByNombre(final String nombre);
	Control findByNumeroControl(final Long numeroControl);
}
