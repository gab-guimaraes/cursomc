package com.johnwick.cursomc.repositories;

import com.johnwick.cursomc.domain.Categoria;
import com.johnwick.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {


}
