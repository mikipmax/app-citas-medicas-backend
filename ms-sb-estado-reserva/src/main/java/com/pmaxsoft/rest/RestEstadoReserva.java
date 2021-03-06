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


import com.pmaxsoft.dto.EstadoReserva;

import com.pmaxsoft.repositorios.RepositorioEstadoReserva;

//Genero los endpoints respectivos
@RestController
public class RestEstadoReserva {
	@Autowired
	private RepositorioEstadoReserva repositorioEspecialidad;

	@GetMapping("/estados-reserva")
	public List<EstadoReserva> listar() {
		return (List<EstadoReserva>) repositorioEspecialidad.findAll();
	}

	@GetMapping("/{id}")
	public EstadoReserva buscar(@PathVariable int id) {
		Optional<EstadoReserva> entidad = repositorioEspecialidad.findById(id);
		if (entidad.isPresent()) {
			return entidad.get();
		}
		return null;
	}
	
	@PostMapping("/insertar")
	public void insertar(@RequestBody EstadoReserva entidad) {
		repositorioEspecialidad.save(entidad);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody EstadoReserva entidad) {
		repositorioEspecialidad.save(entidad);
	}

	@DeleteMapping("/eliminar")
	public void eliminar(@RequestBody EstadoReserva entidad) {
		repositorioEspecialidad.delete(entidad);
	}
}
