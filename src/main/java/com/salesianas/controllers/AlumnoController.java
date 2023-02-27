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

import com.salesianas.dto.AlumnoControlDto;
import com.salesianas.dto.AlumnoDto;
import com.salesianas.dto.AlumnoPracticaDto;
import com.salesianas.dto.AlumnoSalidaDto;
import com.salesianas.dto.ExamenCompletoDto;
import com.salesianas.dto.PracticaCompletaDto;
import com.salesianas.exception.AlumnoNotFoundException;
import com.salesianas.repositories.Alumno;
import com.salesianas.repositories.AlumnoControl;
import com.salesianas.repositories.AlumnoPractica;
import com.salesianas.repositories.Control;
import com.salesianas.repositories.Practica;
import com.salesianas.services.AlumnoServiceI;
import com.salesianas.services.ControlServiceI;
import com.salesianas.services.PracticaServiceI;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoServiceI alumnoService;

	@Autowired
	private PracticaServiceI practicaService;
	@Autowired
	private ControlServiceI controlService;


	@PostMapping("/nuevo")
	public ResponseEntity<Alumno>  crearAlumno(final @RequestBody AlumnoDto alumno) {
		try {
			Alumno nuevo = alumnoService.matricularAlumno(alumno);
			return new ResponseEntity<> (nuevo, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<> (new Alumno(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PutMapping("/modificar/{id}")
	public Alumno modificarAlumno(final @RequestBody AlumnoDto dto,final @PathVariable Long id) {

		return alumnoService.buscarPorMatriculaOptional(id)
				.map(alumno->{
					 alumno.setNombre(dto.getNombre());
					 alumno.setGrupo(dto.getGrupo());
					 return alumnoService.modificarAlumno(alumno);
				}).orElseThrow(()->new AlumnoNotFoundException(id));
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarAlumno(final @PathVariable Long id) {

		if(!alumnoService.alumnoExiste(id)) {
			throw new AlumnoNotFoundException(id);
		}
		
		alumnoService.eliminarAlumno(id);
		return "El alumno con nº de matrícula " + id + " ha sido eliminado con éxito.";
		
	}

	@GetMapping 
	public ResponseEntity<List<Alumno>> buscarTodos() {
		try {
			return new ResponseEntity<> ( alumnoService.buscarTodos(), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<> (new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping ("/{id}")
	public ResponseEntity<AlumnoSalidaDto> buscarPorId(@PathVariable Long id) {
		
		try {
		AlumnoSalidaDto alumnoSalidaDto= new AlumnoSalidaDto();
		Alumno alumno=alumnoService.buscarPorMatricula(id);
		 alumnoSalidaDto.setMatricula(alumno.getMatricula());
		 alumnoSalidaDto.setGrupo(alumno.getGrupo());
		 alumnoSalidaDto.setNombre(alumno.getNombre());
		 
		 List<PracticaCompletaDto> practicas= new ArrayList<>();
		
			List <AlumnoPractica> alumnoPracticaLista=alumno.getPracticas();
			
			for (AlumnoPractica a:alumnoPracticaLista) {
				PracticaCompletaDto practicaDto= new PracticaCompletaDto();
				practicaDto.setCodigoPractica(a.getPractica().getCodigoPractica());
				practicaDto.setTitulo(a.getPractica().getTitulo());
				practicaDto.setDificultad(a.getPractica().getDificultad());
				practicaDto.setFecha(a.getFecha());
				practicaDto.setNota(a.getNota());
				practicas.add(practicaDto);		
				}
			alumnoSalidaDto.setPracticas(practicas);
			
			List<ExamenCompletoDto> controles= new ArrayList<>();
			
			List<AlumnoControl>alumnoControlLista=alumno.getControles();
			
			for(AlumnoControl b:alumnoControlLista) {
				ExamenCompletoDto controlDto= new ExamenCompletoDto();
				controlDto.setNumeroControl(b.getControl().getNumeroControl());
				controlDto.setNombre(b.getControl().getNombre());
				controlDto.setPreguntas(b.getControl().getPreguntas());
				controlDto.setFecha(b.getControl().getFecha());
				controlDto.setNota(b.getNota());
				controles.add(controlDto);
			}
			alumnoSalidaDto.setControles(controles);
		
		return new ResponseEntity<> ( alumnoSalidaDto, HttpStatus.OK);
	} catch(Exception e) {
		return new ResponseEntity<> (new AlumnoSalidaDto(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
		
	
	
	@GetMapping ("/nombre/{nombre}")
	public ResponseEntity<List<Alumno>> buscarPorNombre(@PathVariable String nombre) {
		try {
			return new ResponseEntity<> ( alumnoService.buscarPorNombre(nombre), HttpStatus.OK);
		} catch (Exception ex) {
    		return new ResponseEntity<> (new ArrayList<>(),  HttpStatus.INTERNAL_SERVER_ERROR);
    	}
	}
	
	@GetMapping ("/grupo/{grupo}")
	public ResponseEntity<List<Alumno>> buscarPorGrupo(@PathVariable String grupo) {
		try {
			return new ResponseEntity<> ( alumnoService.buscarPorGrupo(grupo), HttpStatus.OK);
		} catch (Exception ex) {
    		return new ResponseEntity<> (new ArrayList<>(),  HttpStatus.INTERNAL_SERVER_ERROR);
    	}
	}
	
	@PostMapping("/{idAlumno}/hacerPractica/{idPractica}")
	public AlumnoPractica asociarPractica(@PathVariable Long idAlumno, @PathVariable Long idPractica, final @RequestBody AlumnoPracticaDto dto){
		Alumno alumno= alumnoService.buscarPorMatricula(idAlumno);
		Practica practica= practicaService.buscarPorId(idPractica);
		
		AlumnoPractica alumnoPractica=new AlumnoPractica(alumno,practica);
		alumnoPractica.setNota(dto.getNota());
		alumnoPractica.setFecha(dto.getFecha());
		List<AlumnoPractica> alumnosPracticas= new ArrayList<>();
		alumnosPracticas.add(alumnoPractica);
		practica.setAlumnos(alumnosPracticas);
		alumno.setPracticas(alumnosPracticas);
	
		alumnoService.modificarAlumno(alumno);
		practicaService.modificarPractica(practica);
		return alumnoPractica;
		
	}
	
	@PostMapping("/{idAlumno}/hacerControl/{idControl}")
	public AlumnoControl asociarControl(@PathVariable Long idAlumno, @PathVariable Long idControl, final @RequestBody AlumnoControlDto dto) {
		Alumno alumno= alumnoService.buscarPorMatricula(idAlumno);
		Control control= controlService.buscarPorId(idControl);
		
		AlumnoControl alumnoControl= new AlumnoControl(alumno,control);
		alumnoControl.setNota(dto.getNota());
		List<AlumnoControl> alumnosControles= new ArrayList<>();
		alumnosControles.add(alumnoControl);
		control.setAlumnos(alumnosControles);
		alumno.setControles(alumnosControles);
		
		alumnoService.modificarAlumno(alumno);
		controlService.modificarControl(control);
		return alumnoControl;
	}
	
	@GetMapping("/{id}/practicas")
	public List<Practica> getPracticas(@PathVariable Long id){
		List<Practica> result= new ArrayList<>();
		Alumno alumno =alumnoService.buscarPorMatricula(id);
		List <AlumnoPractica> alumnoPracticaLista=alumno.getPracticas();
		for (AlumnoPractica a:alumnoPracticaLista) {
			result.add(a.getPractica());		
			}
		
		return result;
	}
	
}
