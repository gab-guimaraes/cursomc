package com.johnwick.cursomc.resources;

import com.johnwick.cursomc.domain.Cliente;
import com.johnwick.cursomc.domain.Pedido;
import com.johnwick.cursomc.service.ClienteService;
import com.johnwick.cursomc.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Pedido obj = service.buscar(id);
        System.out.println("buscando" + id);
        System.out.println(obj.toString());
        return ResponseEntity.ok().body(obj);

    }

}
