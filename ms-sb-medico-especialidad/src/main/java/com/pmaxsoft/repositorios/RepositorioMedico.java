package com.pmaxsoft.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pmaxsoft.dto.Medico;

@Repository
public interface RepositorioMedico extends CrudRepository<Medico, Integer> {
	List<Medico> findByMediVigenteTrue();
}
