package com.pmaxsoft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TipoPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipa_id")
	private int tipaId;
	@Column(name = "tipa_nombre")
	private String tipaNombre;
	@Column(name = "tipa_vigente")
	private boolean tipaVigente;
}
