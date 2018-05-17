package com.claudiocosta.cursomc.resources;




import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.claudiocosta.cursomc.domain.Cliente;
import com.claudiocosta.cursomc.dto.ClienteDTO;
import com.claudiocosta.cursomc.services.ClienteService;


@RestController
@RequestMapping(value="/clientes")

public class ClienteResource {
	@Autowired
	ClienteService service ;
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET) 
	public ResponseEntity<Cliente> find(@PathVariable Integer id)
	{
		Cliente obj = service.Buscar(id);
		return ResponseEntity.ok().body(obj);
		
		
		
	}
	
	@RequestMapping(method= RequestMethod.GET) 
	public ResponseEntity<List<ClienteDTO>> findAll()
	{
		List<Cliente> ListaCliente = service.BuscarTodos();
		//return ResponseEntity.ok().body(ListaCliente);
		List<ClienteDTO> ListaClienteDTO = ListaCliente.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(ListaClienteDTO);
		
		
	}
	
	@RequestMapping(value ="/page", method= RequestMethod.GET) 
	public ResponseEntity<Page<ClienteDTO>> findPage(
		@RequestParam(value="page", defaultValue="0") Integer Page,
		@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
		@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
		@RequestParam(value="direction", defaultValue="ASC") String direction ){
		Page<Cliente> ListaCliente = service.findPage(Page, linesPerPage, orderBy, direction);
		//return ResponseEntity.ok().body(ListaCliente);
		Page<ClienteDTO> ListaClienteDTO = ListaCliente.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(ListaClienteDTO);
		
		
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT) 
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id)
	 {
		 Cliente obj = service.fromDTO(objDTO);
		 obj.setId(id);
		 obj = service.update(obj);		
		 return ResponseEntity.noContent().build();
	 }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE) 
	public ResponseEntity<Cliente> delete(@PathVariable Integer id)
	{
		 service.delete(id);
		return ResponseEntity.noContent().build();
		
		
		
	}

	

}
