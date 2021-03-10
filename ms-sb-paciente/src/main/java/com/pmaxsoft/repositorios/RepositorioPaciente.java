package com.pmaxsoft.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pmaxsoft.dto.Paciente;


@Repository
public interface RepositorioPaciente extends CrudRepository<Paciente, Integer> {

}
