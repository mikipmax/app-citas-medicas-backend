package com.pmaxsoft.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.pmaxsoft.dto.TipoPago;


@Repository
public interface RepositorioTipoPago extends CrudRepository<TipoPago, Integer> {

}
