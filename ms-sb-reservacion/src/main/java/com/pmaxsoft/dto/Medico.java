package com.pmaxsoft.dto;



import lombok.Data;

@Data
public class Medico {

	private int mediId;
	
	private boolean medi_vigente;
	
	private String mediNombre;
	
	private String mediApellido;
	
	private String mediTelefono;
	
	private String mediEmail;

	private String mediCedula;

	
	private Especialidad especialidad;

}
