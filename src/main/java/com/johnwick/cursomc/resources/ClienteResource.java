package com.johnwick.cursomc.resources;

import com.johnwick.cursomc.domain.Categoria;
import com.johnwick.cursomc.domain.Cliente;
import com.johnwick.cursomc.service.CategoriaService;
import com.johnwick.cursomc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.ClientEndpoint;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id) {
        Cliente obj = service.find(id);
        System.out.println("buscando" + id);
        System.out.println(obj.toString());
        return ResponseEntity.ok().body(obj);

    }

}
