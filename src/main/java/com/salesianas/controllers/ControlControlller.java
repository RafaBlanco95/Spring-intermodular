package com.salesianas.controllers;

import java.time.LocalDate;
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

import com.salesianas.dto.AlumnoCompletoControlDto;
import com.salesianas.dto.ControlDto;
import com.salesianas.dto.ControlSalidaDto;
import com.salesianas.exception.ControlNotFoundException;
import com.salesianas.repositories.AlumnoControl;
import com.salesianas.repositories.Control;
import com.salesianas.services.ControlServiceI;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/controles")
public class ControlControlller {

	@Autowired
	private ControlServiceI controlService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Control> crearControl(final @RequestBody ControlDto dto) {
		try {
			Control nuevo = controlService.crearControl(dto);
			return new ResponseEntity<> (nuevo, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<> (new Control(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping 
	public ResponseEntity<List<Control>> buscarTodos() {
		try {
			return new ResponseEntity<> ( controlService.buscarTodos(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<> (new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar/{id}")
	public Control modificarControl(final @RequestBody ControlDto dto, final @PathVariable Long id) {
		return controlService.buscarPorNumeroControlOptional(id)
				.map(control->{
					 control.setNombre(dto.getNombre());
					 control.setFecha(dto.getFecha());
					 control.setPreguntas(dto.getPreguntas());
					 return controlService.modificarControl(control);
				}).orElseThrow(()->new ControlNotFoundException(id));
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String  eliminarControl(final @PathVariable Long id) {
		if(!controlService.controlExiste(id)) {
			throw new ControlNotFoundException(id);
		}
		
		controlService.eliminarControl(id);
		return "El examen con idintificador " + id + " ha sido eliminado con éxito.";
		
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ControlSalidaDto> buscarPorId(@PathVariable Long id) {
		try {
			ControlSalidaDto controlSalidaDto= new ControlSalidaDto();
			Control control= controlService.buscarPorId(id);
			controlSalidaDto.setNumeroControl(control.getNumeroControl());
			controlSalidaDto.setNombre(control.getNombre());
			controlSalidaDto.setFecha(control.getFecha());
			controlSalidaDto.setPreguntas(control.getPreguntas());
			
			List<AlumnoCompletoControlDto> alumnos= new ArrayList<>();
			
			List<AlumnoControl> alumnoControlLista= control.getAlumnos();
			for (AlumnoControl a: alumnoControlLista) {
				AlumnoCompletoControlDto alumnoDto= new AlumnoCompletoControlDto();
				alumnoDto.setMatricula(a.getAlumno().getMatricula());
				alumnoDto.setNombre(a.getAlumno().getNombre());
				alumnoDto.setGrupo(a.getAlumno().getGrupo());
				alumnoDto.setNota(a.getNota());
				alumnos.add(alumnoDto);
			}
			
			controlSalidaDto.setAlumnos(alumnos);
			return new ResponseEntity<> ( controlSalidaDto, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<> (new ControlSalidaDto(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping ("/fecha/{fecha}")
	public ResponseEntity<List<Control>> buscarPorNombre(@PathVariable LocalDate fecha) {
		try {
			return new ResponseEntity<> ( controlService.buscarPorFecha(fecha), HttpStatus.OK);
		} catch (Exception ex) {
    		return new ResponseEntity<> (new ArrayList<>(),  HttpStatus.INTERNAL_SERVER_ERROR);
    	}
	}
	
	
}
