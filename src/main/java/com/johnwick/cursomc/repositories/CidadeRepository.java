package com.johnwick.cursomc.repositories;

import com.johnwick.cursomc.domain.Categoria;
import com.johnwick.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
