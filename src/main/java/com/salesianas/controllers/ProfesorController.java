package com.salesianas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianas.dto.PracticaDocenteDto;
import com.salesianas.dto.PracticaDto;
import com.salesianas.dto.PracticaProfesorDto;
import com.salesianas.dto.ProfesorDto;
import com.salesianas.dto.ProfesorPracticaDto;
import com.salesianas.dto.ProfesorSalidaDto;
import com.salesianas.exception.ProfesorNotFoundException;
import com.salesianas.repositories.Practica;
import com.salesianas.repositories.Profesor;
import com.salesianas.services.PracticaServiceI;
import com.salesianas.services.ProfesorServiceI;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/profesores")
public class ProfesorController {

	@Autowired
	private ProfesorServiceI profesorService;
	
	@Autowired
	private PracticaServiceI practicaService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Profesor>  crearProfesor(final @RequestBody ProfesorDto dto) {
		try {
			Profesor nuevo = profesorService.inscribirProfesor(dto);
			return new ResponseEntity<> (nuevo, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<> (new Profesor(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar/{id}")
	public Profesor modificarProfesor(final @RequestBody ProfesorDto dto,final @PathVariable Long id) {

		return profesorService.buscarPorNumeroDocenteOptional(id)
				.map(profesor->{
					 profesor.setNombre(dto.getNombre());
					 profesor.setDni(dto.getDni());
					 return profesorService.modificarProfesor(profesor);
				}).orElseThrow(()->new ProfesorNotFoundException(id));
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarProfesor(final @PathVariable Long id) {

		if(!profesorService.profesorExiste(id)) {
			throw new ProfesorNotFoundException(id);
		}
		
		profesorService.eliminaProfesor(id);
		return "El profesor con nº de docente " + id + " ha sido eliminado con éxito.";
		
	}
	
	@GetMapping 
	public ResponseEntity<List<Profesor>> buscarTodos() {
		try {
			return new ResponseEntity<> ( profesorService.buscarTodos(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<> (new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ProfesorSalidaDto> buscarPorId(@PathVariable Long id){
		try {
			ProfesorSalidaDto profesorSalidaDto= new ProfesorSalidaDto();
			Profesor profesor= profesorService.buscarPorNumeroDocente(id);
			profesorSalidaDto.setNumeroDocente(profesor.getNumeroDocente());
			profesorSalidaDto.setNombre(profesor.getNombre());
			profesorSalidaDto.setDni(profesor.getDni());
			
			List<PracticaProfesorDto> practicasDto= new ArrayList<>();
			List<Practica> practicas=profesor.getPracticas();
			
			for(Practica p:practicas) {
				PracticaProfesorDto practicaProfe= new PracticaProfesorDto();
				practicaProfe.setCodigoPractica(p.getCodigoPractica());
				practicaProfe.setTitulo(p.getTitulo());
				practicaProfe.setDificultad(p.getDificultad());
				practicasDto.add(practicaProfe);
			}
			
			profesorSalidaDto.setPracticas(practicasDto);
			return new ResponseEntity<> ( profesorSalidaDto, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<> (new ProfesorSalidaDto(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{idProfesor}/hacerPractica/{idPractica}")
	public Profesor asociarPractica(@PathVariable Long idProfesor, @PathVariable Long idPractica){
		Practica practica= practicaService.buscarPorId(idPractica);
		List<Profesor> profesores= practica.getProfesores();
		List<Practica> practicas= new ArrayList<>();
		Profesor profesor=profesorService.buscarPorNumeroDocente(idProfesor);
		profesores.add(profesor);
		practicas.add(practica);
		practica.setProfesores(profesores);
		profesor.setPracticas(practicas);
		profesorService.modificarProfesor(profesor);
		practicaService.modificarPractica(practica);
		
		return profesor;
		
	}
	
	@PostMapping("/{idProfesor}/nuevaPractica")
	public PracticaDocenteDto hacerPractica(@PathVariable Long idProfesor, @RequestBody PracticaDto dto) {
		List<Profesor> profesores= new ArrayList<>();
		Profesor profesor=profesorService.buscarPorNumeroDocente(idProfesor);
		profesores.add(profesor);
		Practica practica= practicaService.crearPractica(dto);
		practica.setProfesores(profesores);
		practicaService.modificarPractica(practica);
		PracticaDocenteDto practicaDocente= new PracticaDocenteDto();
		practicaDocente.setTitulo(practica.getTitulo());
		practicaDocente.setDificultad(practica.getDificultad());
		
		List<ProfesorPracticaDto> docentes= new ArrayList<>();
		
		for(Profesor p: profesores) {
			ProfesorPracticaDto profesorDto= new ProfesorPracticaDto();
			profesorDto.setNumeroDocente(p.getNumeroDocente());
			profesorDto.setNombre(p.getNombre());
			profesorDto.setDni(p.getDni());
			docentes.add(profesorDto);
		}
		
		practicaDocente.setProfesores(docentes);
		return practicaDocente;
	}
	
	
}
