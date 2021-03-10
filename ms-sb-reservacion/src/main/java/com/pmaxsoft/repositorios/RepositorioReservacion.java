package com.pmaxsoft.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.pmaxsoft.dto.Reservacion;


@Repository
public interface RepositorioReservacion extends CrudRepository<Reservacion, Integer> {

}
