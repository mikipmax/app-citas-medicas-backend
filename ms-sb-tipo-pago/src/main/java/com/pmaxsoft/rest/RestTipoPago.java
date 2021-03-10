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


import com.pmaxsoft.dto.TipoPago;

import com.pmaxsoft.repositorios.RepositorioTipoPago;

@RestController
public class RestTipoPago {
	@Autowired
	private RepositorioTipoPago repositorioTipoPago;

	@GetMapping("/tipos-pago")
	public List<TipoPago> listar() {
		return (List<TipoPago>) repositorioTipoPago.findAll();
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
