package com.pmaxsoft.dto;
/*
***UNIVERSIDAD CENTRAL DEL ECUADOR***
***FACULTAD DE INGENIERIA Y CIENCIAS APLICADAS***
***CARRERAS: INGENIERÍA EN COMPUTACIÓN GRÁFICA​E INGENIERÍA INFORMÁTICA***
***MATERIA: DISPOSITIVOS MÓVILES***

Grupo N: 5
Integrantes:  -Nicolalde Estefanía ​Correo: jenicolaldep@uce.edu.ec
              -Ponce Michael​​Correo: mfponce@uce.edu.ec
              -Sánchez Jonathan​​Correo: jjsanchezl1@uce.edu.ec
              -Tituaña Mayra​Correo: mrtituana@uce.edu.ec
Descripción: La aplicación DATAMED se manifiesta de forma similar a una agenda, y tiene el propósito
*            de agilizar el proceso de consulta. Consume microservicios alojados en un servidor de
*            cloud gratuito, permite a los administrativos registrar las citas médicas de
*            los pacientes brindando la facilidad de gestionar parámetros como: la fecha,
*            especialista, área y tipo de pago.
*/
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Reservacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rese_id")
	private int reseId;
	@Column(name = "rese_fecha")
	private LocalDate reseFecha;
	@Column(name = "rese_hora")
	private LocalTime reseHora;
	@Column(name = "rese_descripcion")
	private String reseDescripcion;
	@Column(name = "medi_id")
	private int mediId;
	@Column(name = "paci_id")
	private int paciId;
	@Column(name = "esre_id")
	private int esreId;
	@Column(name = "tipa_id")
	private int tipaId;
	@Transient
	private TipoPago tipoPago;
	@Transient
	private Paciente paciente;
	@Transient
	private Medico medico;
	@Transient
	private EstadoReserva estadoReserva;

	public Reservacion(int reseId) {

		this.reseId = reseId;
	}

}
