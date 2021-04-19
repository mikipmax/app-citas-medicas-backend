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


import com.pmaxsoft.dto.Especialidad;

import com.pmaxsoft.repositorios.RepositorioEspecialidad;

//Genero los endpoints respectivos
@RestController
public class RestEspecialidad {
	@Autowired
	private RepositorioEspecialidad repositorioEspecialidad;

	@GetMapping("/especialidades")
	public List<Especialidad> listar() {
		return (List<Especialidad>) repositorioEspecialidad.findAll();
	}
	@GetMapping("/especialidades-vigentes")
	public List<Especialidad> listarVigentes() {
		return (List<Especialidad>) repositorioEspecialidad.findByEspeVigenteTrue();
	}

	@GetMapping("/especialidad/{id}")
	public Especialidad buscar(@PathVariable int id) {
		Optional<Especialidad> entidad = repositorioEspecialidad.findById(id);
		if (entidad.isPresent()) {
			return entidad.get();
		}
		return null;
	}
	
	@PostMapping("/especialidad/insertar")
	public void insertar(@RequestBody Especialidad entidad) {
		repositorioEspecialidad.save(entidad);
	}

	@PutMapping("/especialidad/actualizar")
	public void actualizar(@RequestBody Especialidad entidad) {
		repositorioEspecialidad.save(entidad);
	}

	@DeleteMapping("/especialidad/eliminar")
	public void eliminar(@RequestBody Especialidad entidad) {
		repositorioEspecialidad.delete(entidad);
	}
}
