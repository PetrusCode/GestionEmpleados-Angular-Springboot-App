package com.pedrodevelopments.gestionempleados.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrodevelopments.gestionempleados.dao.EmpleadoRepository;
import com.pedrodevelopments.gestionempleados.model.Empleado;

@Service
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

}
