package com.salesianas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticaRepositoryI extends JpaRepository<Practica, Long>{

	List<Practica> findByTitulo(String titulo);
	List<Practica> findByDificultad(int dificultad);
	Practica findByCodigoPractica(Long codigoPractica);
}
