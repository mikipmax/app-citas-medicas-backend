package com.pmaxsoft.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pmaxsoft.dto.TipoPago;
import com.pmaxsoft.dto.EstadoReserva;
import com.pmaxsoft.dto.Medico;
import com.pmaxsoft.dto.Paciente;
import com.pmaxsoft.dto.Reservacion;

import com.pmaxsoft.repositorios.RepositorioReservacion;

@RestController
public class RestReservacion {
	private RestTemplate restTemplate;

	@PostConstruct
	protected void inicializar() {
		restTemplate = new RestTemplate();
	}

	@Autowired
	private RepositorioReservacion repositorioEspecialidad;

	@GetMapping("/reservaciones")
	public List<Reservacion> listar() {
		Map<Integer, TipoPago> cacheTipoPago = new HashMap<>();
		Stream.of(restTemplate.getForObject("https://ms-sb-tipo-pago.herokuapp.com/tipos-pago", TipoPago[].class))
				.forEach(s -> {
					cacheTipoPago.put(s.getTipaId(), s);
				});

		Map<Integer, EstadoReserva> cacheEstadoReserva = new HashMap<>();
		Stream.of(restTemplate.getForObject("https://ms-sb-estado-reserva.herokuapp.com/estados-reserva",
				EstadoReserva[].class)).forEach(s -> {
					cacheEstadoReserva.put(s.getEsreId(), s);
				});

		Map<Integer, Medico> cacheMedico = new HashMap<>();
		Stream.of(restTemplate.getForObject("https://ms-sb-medico-especialidad.herokuapp.com/medicos", Medico[].class))
				.forEach(s -> {
					cacheMedico.put(s.getMediId(), s);
				});

		Map<Integer, Paciente> cachePaciente = new HashMap<>();
		Stream.of(restTemplate.getForObject("https://ms-sb-paciente.herokuapp.com/pacientes", Paciente[].class))
				.forEach(s -> {
					cachePaciente.put(s.getPaciId(), s);
				});

		List<Reservacion> lista = (List<Reservacion>) repositorioEspecialidad.findAll();
		lista.stream().map(s -> {
			s.setTipoPago(cacheTipoPago.get(s.getTipaId()));
			s.setEstadoReserva(cacheEstadoReserva.get(s.getEsreId()));
			s.setMedico(cacheMedico.get(s.getMediId()));
			s.setPaciente(cachePaciente.get(s.getPaciId()));
			return s;
		}).collect(Collectors.toList());
		return lista;
	}

	@GetMapping("/{id}")
	public Reservacion buscar(@PathVariable int id) {

		Optional<Reservacion> entidad = repositorioEspecialidad.findById(id);
		if (entidad.isPresent()) {
			Reservacion medico = entidad.get();
			Map<Integer, TipoPago> cacheTipoPago = new HashMap<>();
			Stream.of(restTemplate.getForObject("https://ms-sb-tipo-pago.herokuapp.com/" + medico.getTipaId(),
					TipoPago.class)).forEach(s -> cacheTipoPago.put(s.getTipaId(), s));

			Map<Integer, EstadoReserva> cacheEstadoReserva = new HashMap<>();
			Stream.of(restTemplate.getForObject("https://ms-sb-estado-reserva.herokuapp.com/" + medico.getEsreId(),
					EstadoReserva.class)).forEach(s -> cacheEstadoReserva.put(s.getEsreId(), s));

			Map<Integer, Medico> cacheMedico = new HashMap<>();
			Stream.of(restTemplate.getForObject(
					"https://ms-sb-medico-especialidad.herokuapp.com/medico/" + medico.getMediId(), Medico.class))
					.forEach(s -> cacheMedico.put(s.getMediId(), s));

			Map<Integer, Paciente> cachePaciente = new HashMap<>();
			Stream.of(restTemplate.getForObject("https://ms-sb-paciente.herokuapp.com/" + medico.getPaciId(),
					Paciente.class)).forEach(s -> cachePaciente.put(s.getPaciId(), s));

			medico = entidad.stream().map(s -> {
				s.setTipoPago(cacheTipoPago.get(s.getTipaId()));
				s.setEstadoReserva(cacheEstadoReserva.get(s.getEsreId()));
				s.setMedico(cacheMedico.get(s.getMediId()));
				s.setPaciente(cachePaciente.get(s.getPaciId()));
				return s;
			}).findFirst().get();
			return medico;
		}
		return null;
	}

	@PostMapping("/insertar")
	public void insertar(@RequestBody Reservacion entidad) {
		repositorioEspecialidad.save(entidad);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Reservacion entidad) {
		repositorioEspecialidad.save(entidad);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable int id) {
		repositorioEspecialidad.delete(new Reservacion(id));
	}
}
