package com.pmaxsoft.dto;

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
