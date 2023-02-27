package com.salesianas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianas.dto.PracticaDto;
import com.salesianas.repositories.Practica;
import com.salesianas.repositories.PracticaRepositoryI;

@Service
public class PracticaServiceImpl implements PracticaServiceI{
	
	@Autowired
	private PracticaRepositoryI practicaRepo;

	@Override
	public Practica crearPractica(PracticaDto dto) {
		Practica nueva=new Practica();
		nueva.setTitulo(dto.getTitulo());
		nueva.setDificultad(dto.getDificultad());
		return practicaRepo.save(nueva);
	}

	@Override
	public Practica modificarPractica(Practica practica) {
		
		return practicaRepo.save(practica);
	}

	@Override
	public boolean practicaExiste(Long id) {
		
		return practicaRepo.existsById(id);
	}

	@Override
	public void eliminarPractica(Long id) {
		practicaRepo.deleteById(id);
		
	}

	@Override
	public Practica buscarPorId(Long id) {
		
		return practicaRepo.findByCodigoPractica(id);
	}

	@Override
	public Optional<Practica> buscarPorCodigoPracticaOptional(Long codigoPractica) {
		
		return practicaRepo.findById(codigoPractica);
	}

	@Override
	public List<Practica> buscarPorTitulo(String titulo) {
		
		return practicaRepo.findByTitulo(titulo);
	}

	@Override
	public List<Practica> buscarPorDificultad(int dificultad) {
		
		return practicaRepo.findByDificultad(dificultad);
	}

	@Override
	public List<Practica> buscarTodos() {
		
		return practicaRepo.findAll();
	}

	

}
