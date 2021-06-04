package com.pedrodevelopments.gestionempleados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	@NotNull(message = "The id should not be null")
	@Positive(message = "The id should be greater than 0")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "email")
	private String email;

	@Column(name = "puestoNombre")
	private String puestoNombre;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "fotoDePerfilUrl")
	private String fotoDePerfilUrl;

	@Column(name = "codigoEmpleado", nullable = false, updatable = false)
	private String codigoEmpleado;
}
