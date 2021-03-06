package com.claudiocosta.cursomc.resources;



import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.claudiocosta.cursomc.domain.Pedido;

import com.claudiocosta.cursomc.services.PedidoService;


@RestController
@RequestMapping(value="/pedidos")

public class PedidoResource {
	@Autowired
	PedidoService service ;
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET) 
	public ResponseEntity<Pedido> find(@PathVariable Integer id)
	{
		Pedido obj = service.Buscar(id);
		return ResponseEntity.ok().body(obj);
		
		
		
	}
	
	@RequestMapping(method= RequestMethod.POST)
	 public ResponseEntity<Void> Insert(@Valid @RequestBody Pedido obj)
	 {
		 
		 obj = service.insert(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	 }
	

}
