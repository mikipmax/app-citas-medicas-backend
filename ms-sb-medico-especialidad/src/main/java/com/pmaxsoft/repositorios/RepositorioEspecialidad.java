package com.pmaxsoft.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.pmaxsoft.dto.Especialidad;


@Repository
public interface RepositorioEspecialidad extends CrudRepository<Especialidad, Integer> {
List<Especialidad> findByEspeVigenteTrue();
}
