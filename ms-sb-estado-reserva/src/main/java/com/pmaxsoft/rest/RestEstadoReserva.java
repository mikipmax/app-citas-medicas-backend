package com.pmaxsoft.rest;

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
