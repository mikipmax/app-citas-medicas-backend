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


import com.pmaxsoft.dto.Especialidad;

import com.pmaxsoft.repositorios.RepositorioEspecialidad;

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
