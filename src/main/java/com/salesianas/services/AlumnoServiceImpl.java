package com.salesianas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianas.dto.AlumnoDto;
import com.salesianas.repositories.Alumno;
import com.salesianas.repositories.AlumnoRepositoryI;

@Service
public class AlumnoServiceImpl implements AlumnoServiceI {

	@Autowired
	private AlumnoRepositoryI alumnoRepo;

	@Override
	public Alumno matricularAlumno(AlumnoDto dto) {
		Alumno nuevo= new Alumno();
		nuevo.setNombre(dto.getNombre());
		nuevo.setGrupo(dto.getGrupo());
		
		return alumnoRepo.save(nuevo);
	}

	@Override
	public Alumno modificarAlumno(Alumno alumno) {

			return alumnoRepo.save(alumno);
		
	}

	@Override
	public void eliminarAlumno(Long id) {
		
		alumnoRepo.deleteById(id);
		
	}

	@Override
	public Alumno buscarPorMatricula(Long id) {
		
		return alumnoRepo.findByMatricula(id);
	}

	@Override
	public List<Alumno> buscarPorNombre(String nombre) {
		
		return alumnoRepo.findByNombre(nombre);
	}

	@Override
	public List<Alumno> buscarPorGrupo(String grupo) {
		
		return alumnoRepo.findByGrupo(grupo);
	}

	@Override
	public List<Alumno> buscarTodos() {
		
		return alumnoRepo.findAll();
	}

	@Override
	public Optional<Alumno> buscarPorMatriculaOptional(Long id) {
		
		return alumnoRepo.findById(id);
	}

	@Override
	public boolean alumnoExiste(Long id) {
		
		return alumnoRepo.existsById(id);
	}
	
	
	
}
