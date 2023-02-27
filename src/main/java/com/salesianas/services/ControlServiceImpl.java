package com.salesianas.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianas.dto.ControlDto;
import com.salesianas.repositories.Control;
import com.salesianas.repositories.ControlRepositoryI;

@Service
public class ControlServiceImpl implements ControlServiceI {

	@Autowired
	private ControlRepositoryI controlRepo;

	@Override
	public Control crearControl(ControlDto dto) {
		Control nuevo = new Control();
		nuevo.setNombre(dto.getNombre());
		nuevo.setPreguntas(dto.getPreguntas());
		nuevo.setFecha(dto.getFecha());
		return controlRepo.save(nuevo);
	}

	@Override
	public Control modificarControl(Control control) {
		
		return controlRepo.save(control);
	}

	@Override
	public boolean controlExiste(Long id) {
		
		return controlRepo.existsById(id);
	}

	@Override
	public void eliminarControl(Long id) {
		controlRepo.deleteById(id);

	}

	@Override
	public Control buscarPorId(Long id) {
		
		return controlRepo.findByNumeroControl(id);
	}

	@Override
	public Optional<Control> buscarPorNumeroControlOptional(Long numeroControl) {
		
		return controlRepo.findById(numeroControl);
	}

	@Override
	public List<Control> buscarPorPreguntas(int preguntas) {
		
		return controlRepo.findByPreguntas(preguntas);
	}

	@Override
	public List<Control> buscarPorFecha(LocalDate fecha) {
		
		return controlRepo.findByFecha(null);
	}

	@Override
	public List<Control> buscarPorNombre(String nombre) {
	
		return controlRepo.findByNombre(nombre);
	}

	@Override
	public List<Control> buscarTodos() {
		
		return controlRepo.findAll();
	}

}
