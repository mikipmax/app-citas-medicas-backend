package com.pmaxsoft.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.pmaxsoft.dto.Especialidad;


@Repository
public interface RepositorioEspecialidad extends CrudRepository<Especialidad, Integer> {

}
