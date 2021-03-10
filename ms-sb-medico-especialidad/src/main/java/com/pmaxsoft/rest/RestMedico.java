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
import com.pmaxsoft.dto.Medico;

import com.pmaxsoft.repositorios.RepositorioMedico;

@RestController
public class RestMedico {
	

	

	@Autowired
	private RepositorioMedico repositorioEspecialidad;

	@GetMapping("/medicos")
	public List<Medico> listar() {

		return (List<Medico>) repositorioEspecialidad.findAll();
	}

	@GetMapping("/medico/{id}")
	public Medico buscar(@PathVariable int id) {

		Optional<Medico> entidad = repositorioEspecialidad.findById(id);
		if (entidad.isPresent()) {
			Medico medico = entidad.get();

			return medico;
		}
		return null;
	}

	@PostMapping("/medico/insertar")
	public void insertar(@RequestBody Medico entidad) {
		repositorioEspecialidad.save(entidad);
	}

	@PutMapping("/medico/actualizar")
	public void actualizar(@RequestBody Medico entidad) {
		repositorioEspecialidad.save(entidad);
	}

	@DeleteMapping("/medico/eliminar")
	public void eliminar(@RequestBody Medico entidad) {
		repositorioEspecialidad.delete(entidad);
	}
}
