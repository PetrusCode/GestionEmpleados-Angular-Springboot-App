package com.pedrodevelopments.gestionempleados.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrodevelopments.gestionempleados.dao.EmpleadoRepository;
import com.pedrodevelopments.gestionempleados.exceptions.UserNotFoundException;
import com.pedrodevelopments.gestionempleados.model.Empleado;

@Service
@Transactional
public class ServicioEmpleado {

	private final EmpleadoRepository empleadoRepository;

	@Autowired
	public ServicioEmpleado(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}

	public Empleado agregarEmpleado(Empleado empleado) {
		empleado.setCodigoEmpleado(UUID.randomUUID().toString());
		return empleadoRepository.save(empleado);

	}

	public List<Empleado> encontrarTodosLosEmpleados() {

		return empleadoRepository.findAll();

	}

	public Empleado actualizarEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);

	}

	public Empleado encontrarPorId(Long id) {
		return empleadoRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(
						"User by id" + id + " not found"));
	}

	public void borrarEmpleado(Long id) {
		empleadoRepository.deleteById(id);
	}
}
