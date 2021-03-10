package com.pmaxsoft.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.pmaxsoft.dto.EstadoReserva;


@Repository
public interface RepositorioEstadoReserva extends CrudRepository<EstadoReserva, Integer> {

}
