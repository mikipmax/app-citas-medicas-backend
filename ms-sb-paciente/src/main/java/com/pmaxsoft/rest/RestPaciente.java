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

import com.pmaxsoft.dto.Paciente;
import com.pmaxsoft.repositorios.RepositorioPaciente;

@RestController
public class RestPaciente {
	@Autowired
	private RepositorioPaciente repositorioPaciente;

	@GetMapping("/pacientes")
	public List<Paciente> listar() {
		return (List<Paciente>) repositorioPaciente.findAll();
	}

	@GetMapping("/{id}")
	public Paciente buscar(@PathVariable int id) {
		Optional<Paciente> paciente = repositorioPaciente.findById(id);
		if (paciente.isPresent()) {
			return paciente.get();
		}
		return null;
	}
	
	@PostMapping("/insertar")
	public void insertar(@RequestBody Paciente paciente) {
		repositorioPaciente.save(paciente);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Paciente paciente) {
		repositorioPaciente.save(paciente);
	}

	@DeleteMapping("/eliminar")
	public void eliminar(@RequestBody Paciente paciente) {
		repositorioPaciente.delete(paciente);
	}
}
