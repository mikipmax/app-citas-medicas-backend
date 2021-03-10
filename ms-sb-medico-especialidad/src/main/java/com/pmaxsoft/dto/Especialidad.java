package com.pmaxsoft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="espe_id") 
	private int espeId;
	@Column(name="espe_nombre") 
	private String espeNombre;
	@Column(name="espe_precio") 
	private double espePrecio;
	@Column(name="espe_vigente") 
	private boolean espeVigente;

}
