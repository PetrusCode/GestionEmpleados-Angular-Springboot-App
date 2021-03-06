package com.pedrodevelopments.gestionempleados.controller;

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

import com.pedrodevelopments.gestionempleados.model.Empleado;
import com.pedrodevelopments.gestionempleados.service.ServicioEmpleado;

@CrossOrigin
@RestController
@RequestMapping("/empleado")
public class RecursoEmpleado {

	@Autowired
	private final ServicioEmpleado servicioEmpleado;

	public RecursoEmpleado(ServicioEmpleado servicioEmpleado) {

		this.servicioEmpleado = servicioEmpleado;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Empleado>> devuelveTodosLosEmpleados() {
		List<Empleado> empleados = servicioEmpleado
				.encontrarTodosLosEmpleados();

		return new ResponseEntity<>(empleados, HttpStatus.OK);

		// Forma corta<--
		// return
		// ResponseEntity.ok(servicioEmpleado.encontrarTodosLosEmpleados());
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Empleado> devuelveEmpleadosPorId(
			@PathVariable("id") Long id) {
		Empleado empleados = servicioEmpleado.encontrarPorId(id);

		return new ResponseEntity<>(empleados, HttpStatus.OK);

		// Forma corta<--
		// return
		// ResponseEntity.ok(servicioEmpleado.encontrarTodosLosEmpleados());
	}

	@PostMapping("/add")
	public ResponseEntity<Empleado> agregarEmpleado(

			@RequestBody Empleado empleado) {

		Empleado agregarEmpleado = servicioEmpleado.agregarEmpleado(empleado);
		return new ResponseEntity<>(agregarEmpleado, HttpStatus.CREATED);

		// Forma corta<--
		// return ResponseEntity.ok(servicioEmpleado.agregarEmpleado(empleado));

	}

	@PutMapping("/update")
	public ResponseEntity<Empleado> actualizarrEmpleado(
			@RequestBody Empleado empleado) {

		Empleado actualizarEmpleado = servicioEmpleado
				.actualizarEmpleado(empleado);

		return new ResponseEntity<>(actualizarEmpleado, HttpStatus.OK);

		// Forma corta<--
		// return ResponseEntity.ok(servicioEmpleado.agregarEmpleado(empleado));

	}

	/*
	 * @Autowired EmpleadoRepository empleadoRepository;
	 * 
	 * @PutMapping("/update/{id}") public ResponseEntity<Empleado>
	 * actualizarEmpleadoById(
	 * 
	 * @PathVariable("id") Long id, @RequestBody Empleado empleado) {
	 * Optional<Empleado> datosEmpleado = empleadoRepository.findById(id);
	 * 
	 * if (datosEmpleado.isPresent()) { Empleado _empleado =
	 * datosEmpleado.get(); _empleado.setNombre(empleado.getNombre());
	 * _empleado.setEmail(empleado.getEmail());
	 * _empleado.setPuestoNombre(empleado.getCodigoEmpleado());
	 * _empleado.setFotoDePerfilUrl(empleado.getFotoDePerfilUrl());
	 * _empleado.setTelefono(empleado.getTelefono());
	 * _empleado.setCodigoEmpleado(empleado.getCodigoEmpleado());
	 * 
	 * return new ResponseEntity<>(empleadoRepository.save(empleado),
	 * HttpStatus.OK); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> borrarEmpleado(@PathVariable("id") Long id) {

		servicioEmpleado.borrarEmpleado(id);
		return new ResponseEntity<>(HttpStatus.OK);

		// Otra forma de borrar
		/*
		 * servicioEmpleado.borrarEmpleado(id); return
		 * ResponseEntity.ok().build();
		 */

	}
}
