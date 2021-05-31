package com.pedrodevelopments.gestionempleados.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrodevelopments.gestionempleados.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

};
