package com.johnwick.cursomc.repositories;

import com.johnwick.cursomc.domain.Cidade;
import com.johnwick.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {


}
