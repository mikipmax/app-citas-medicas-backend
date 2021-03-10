package com.pmaxsoft.dto;

import lombok.Data;

@Data
public class Paciente {

	private int paciId;
	private String paciNombre;
	private String paciApellido;
	private String paciTelefono;
	private String paciCedula;
	private String paciEmail;
	private String paciAntecedentes;

}
