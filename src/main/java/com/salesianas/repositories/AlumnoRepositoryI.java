package com.salesianas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositoryI extends JpaRepository<Alumno, Long>{

	Alumno findByMatricula(final Long matricula);
	
	List<Alumno> findByNombre(final String nombre);
	
	List<Alumno> findByGrupo(final String grupo);
}
