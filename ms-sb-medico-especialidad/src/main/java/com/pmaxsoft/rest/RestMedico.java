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
import com.pmaxsoft.dto.Medico;

import com.pmaxsoft.repositorios.RepositorioMedico;

//Genero los endpoints respectivos
@RestController
public class RestMedico {

	@Autowired
	private RepositorioMedico repositorioEspecialidad;

	@GetMapping("/medicos")
	public List<Medico> listar() {

		return (List<Medico>) repositorioEspecialidad.findAll();
	}

	@GetMapping("/medicos-vigentes")
	public List<Medico> listarVigentes() {
		return (List<Medico>) repositorioEspecialidad.findByMediVigenteTrue();
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
