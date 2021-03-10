package com.pmaxsoft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Entity
@Data
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medi_id")
	private int mediId;
	@Column(name = "medi_vigente")
	private boolean medi_vigente;
	@Column(name = "medi_nombre")
	private String mediNombre;
	@Column(name = "medi_apellido")
	private String mediApellido;
	@Column(name = "medi_telefono")
	private String mediTelefono;
	@Column(name = "medi_email")
	private String mediEmail;
	@Column(name = "medi_cedula")
	private String mediCedula;

	@JoinColumn(name = "espe_id", referencedColumnName = "espe_id")
	@ManyToOne
	private Especialidad especialidad;

}
