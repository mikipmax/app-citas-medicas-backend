package com.pmaxsoft.rest;
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
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmaxsoft.dto.TipoPago;

import com.pmaxsoft.repositorios.RepositorioTipoPago;
//Genero los endpoints respectivos
@RestController
public class RestTipoPago {
	@Autowired
	private RepositorioTipoPago repositorioTipoPago;

	@GetMapping("/tipos-pago")
	public List<TipoPago> listar() {
		return (List<TipoPago>) repositorioTipoPago.findAll();
	}

	@GetMapping("/tipos-pago-vigentes")
	public List<TipoPago> listarVigentes() {
		return (List<TipoPago>) repositorioTipoPago.findByTipaVigenteTrue();
	}

	@GetMapping("/{id}")
	public TipoPago buscar(@PathVariable int id) {
		Optional<TipoPago> entidad = repositorioTipoPago.findById(id);
		if (entidad.isPresent()) {
			return entidad.get();
		}
		return null;
	}

	@PostMapping("/insertar")
	public void insertar(@RequestBody TipoPago entidad) {
		repositorioTipoPago.save(entidad);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody TipoPago entidad) {
		repositorioTipoPago.save(entidad);
	}

	@DeleteMapping("/eliminar")
	public void eliminar(@RequestBody TipoPago entidad) {
		repositorioTipoPago.delete(entidad);
	}
}
