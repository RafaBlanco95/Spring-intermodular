package com.salesianas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianas.dto.ProfesorDto;
import com.salesianas.repositories.Profesor;
import com.salesianas.repositories.ProfesorRepositoryI;

@Service
public class ProfesorServiceImpl implements ProfesorServiceI {

	@Autowired
	private ProfesorRepositoryI profesorRepo;

	@Override
	public Profesor inscribirProfesor(ProfesorDto dto) {
		Profesor profesor = new Profesor();
		profesor.setNombre(dto.getNombre());
		profesor.setDni(dto.getDni());

		return profesorRepo.save(profesor);
	}

	@Override
	public Profesor modificarProfesor(Profesor profesor) {
		
		return profesorRepo.save(profesor);
	}

	@Override
	public boolean profesorExiste(Long id) {
		
		return profesorRepo.existsById(id);
	}

	@Override
	public void eliminaProfesor(Long id) {
		profesorRepo.deleteById(id);

	}

	@Override
	public Profesor buscarPorNumeroDocente(Long id) {
		
		return profesorRepo.findByNumeroDocente(id);
	}

	@Override
	public Optional<Profesor> buscarPorNumeroDocenteOptional(Long id) {
		
		return profesorRepo.findById(id);
	}

	@Override
	public List<Profesor> buscarPorNombre(String nombre) {
		
		return profesorRepo.findByNombre(nombre);
	}

	@Override
	public List<Profesor> buscarPorDni(String dni) {
		
		return profesorRepo.findByDni(dni);
	}

	@Override
	public List<Profesor> buscarTodos() {
		
		return profesorRepo.findAll();
	}

}
