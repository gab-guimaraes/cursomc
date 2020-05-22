package com.johnwick.cursomc.repositories;

import com.johnwick.cursomc.domain.Pagamento;
import com.johnwick.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {


}
