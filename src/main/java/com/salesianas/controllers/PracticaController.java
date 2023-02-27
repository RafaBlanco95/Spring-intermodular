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

import com.salesianas.dto.AlumnoCompletoDto;
import com.salesianas.dto.PracticaDto;
import com.salesianas.dto.PracticaSalidaDto;
import com.salesianas.dto.ProfesorPracticaDto;
import com.salesianas.exception.PracticaNotFoundException;
import com.salesianas.repositories.AlumnoPractica;
import com.salesianas.repositories.Practica;
import com.salesianas.repositories.Profesor;
import com.salesianas.services.PracticaServiceI;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/practicas")
public class PracticaController {

	@Autowired
	private PracticaServiceI practicaService;
	
	@PostMapping("/nueva")
	public ResponseEntity<Practica> crearPractica(final @RequestBody PracticaDto practicaDto){
		try {
			Practica nueva=practicaService.crearPractica(practicaDto);
					return new ResponseEntity<>(nueva, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<> (new Practica(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping 
	public ResponseEntity<List<Practica>> buscarTodos() {
		try {
			return new ResponseEntity<> ( practicaService.buscarTodos(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<> (new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar/{id}")
	public Practica modificarPractica(final @RequestBody PracticaDto dto,final @PathVariable Long id) {

		return practicaService.buscarPorCodigoPracticaOptional(id)
				.map(practica->{
					 practica.setTitulo(dto.getTitulo());
					 practica.setDificultad(dto.getDificultad());
					 return practicaService.modificarPractica(practica);
				}).orElseThrow(()->new PracticaNotFoundException(id));
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarPractica(final @PathVariable Long id) {

		if(!practicaService.practicaExiste(id)) {
			throw new PracticaNotFoundException(id);
		}
		
		practicaService.eliminarPractica(id);
		return "La práctica con nº de práctica " + id + " ha sido eliminada con éxito.";
	}
	
	
	@GetMapping ("/{id}")
	public ResponseEntity<PracticaSalidaDto> buscarPorId(@PathVariable Long id) {
		try {
		
		PracticaSalidaDto practicaSalidaDto= new PracticaSalidaDto();
		Practica practica= practicaService.buscarPorId(id);
		practicaSalidaDto.setCodigoPractica(practica.getCodigoPractica());
		practicaSalidaDto.setTitulo(practica.getTitulo());
		practicaSalidaDto.setDificultad(practica.getDificultad());
		
		List<AlumnoCompletoDto> alumnos= new ArrayList<>();
		
		List<AlumnoPractica> alumnoPracticas=practica.getAlumnos();
		for(AlumnoPractica a: alumnoPracticas) {
			AlumnoCompletoDto alumnoDto= new AlumnoCompletoDto();
			alumnoDto.setMatricula(a.getAlumno().getMatricula());
			alumnoDto.setNombre(a.getAlumno().getNombre());
			alumnoDto.setGrupo(a.getAlumno().getGrupo());
			alumnoDto.setFecha(a.getFecha());
			alumnoDto.setNota(a.getNota());
			alumnos.add(alumnoDto);
		}
		practicaSalidaDto.setAlumnos(alumnos);
		
		
		List<ProfesorPracticaDto> profesores= new ArrayList<>();
		
		List<Profesor> profesorPractica= practica.getProfesores();
		
		for(Profesor p:profesorPractica) {
			ProfesorPracticaDto profesorDto= new ProfesorPracticaDto();
			profesorDto.setNumeroDocente(p.getNumeroDocente());
			profesorDto.setNombre(p.getNombre());
			profesorDto.setDni(p.getDni());
			profesores.add(profesorDto);
		}
		practicaSalidaDto.setProfesores(profesores);
		
		return new ResponseEntity<> ( practicaSalidaDto, HttpStatus.OK);	
	} catch(Exception e) {
		return new ResponseEntity<> (new PracticaSalidaDto(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping ("/titulo/{titulo}")
	public ResponseEntity<List<Practica>> buscarPorTitulo(@PathVariable String titulo) {
		try {
			return new ResponseEntity<> ( practicaService.buscarPorTitulo(titulo), HttpStatus.OK);
		} catch (Exception ex) {
    		return new ResponseEntity<> (new ArrayList<>(),  HttpStatus.INTERNAL_SERVER_ERROR);
    	}
	}
	
	@GetMapping ("/dificultad/{dificultad}")
	public ResponseEntity<List<Practica>> buscarPorDificultad(@PathVariable int dificultad) {
		try {
			return new ResponseEntity<> ( practicaService.buscarPorDificultad(dificultad), HttpStatus.OK);
		} catch (Exception ex) {
    		return new ResponseEntity<> (new ArrayList<>(),  HttpStatus.INTERNAL_SERVER_ERROR);
    	}
	}
	
}
