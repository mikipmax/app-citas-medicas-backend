package com.pmaxsoft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paci_id")
	private int paciId;
	@Column(name = "paci_nombre")
	private String paciNombre;
	@Column(name = "paci_apellido")
	private String paciApellido;
	@Column(name = "paci_telefono")
	private String paciTelefono;
	@Column(name = "paci_cedula")
	private String paciCedula;
	@Column(name = "paci_email")
	private String paciEmail;
	@Column(name = "paci_antecedentes")
	private String paciAntecedentes;

}
