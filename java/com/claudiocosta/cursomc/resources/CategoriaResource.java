package com.claudiocosta.cursomc.resources;



import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.claudiocosta.cursomc.domain.Categoria;
import com.claudiocosta.cursomc.dto.CategoriaDTO;
import com.claudiocosta.cursomc.services.CategoriaService;


@RestController
@RequestMapping(value="/categorias")

public class CategoriaResource {
	@Autowired
	CategoriaService service ;
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET) 
	public ResponseEntity<Categoria> find(@PathVariable Integer id)
	{
		Categoria obj = service.Buscar(id);
		return ResponseEntity.ok().body(obj);
		
		
		
	}
	
	@RequestMapping(method= RequestMethod.GET) 
	public ResponseEntity<List<CategoriaDTO>> findAll()
	{
		List<Categoria> ListaCategoria = service.BuscarTodos();
		//return ResponseEntity.ok().body(ListaCategoria);
		List<CategoriaDTO> ListaCategoriaDTO = ListaCategoria.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(ListaCategoriaDTO);
		
		
	}
	
	@RequestMapping(value ="/page", method= RequestMethod.GET) 
	public ResponseEntity<Page<CategoriaDTO>> findPage(
		@RequestParam(value="page", defaultValue="0") Integer Page,
		@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
		@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
		@RequestParam(value="direction", defaultValue="ASC") String direction ){
		Page<Categoria> ListaCategoria = service.findPage(Page, linesPerPage, orderBy, direction);
		//return ResponseEntity.ok().body(ListaCategoria);
		Page<CategoriaDTO> ListaCategoriaDTO = ListaCategoria.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(ListaCategoriaDTO);
		
		
	}
	@RequestMapping(method= RequestMethod.POST)
 public ResponseEntity<Void> Insert(@Valid @RequestBody CategoriaDTO objDTO)
 {
	 Categoria obj = service.fromDTO(objDTO);
	 obj = service.insert(obj);
	 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	 return ResponseEntity.created(uri).build();
 }
	@RequestMapping(value="/{id}", method= RequestMethod.PUT) 
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Integer id)
	 {
		 Categoria obj = service.fromDTO(objDTO);
		 obj.setId(id);
		 obj = service.update(obj);		
		 return ResponseEntity.noContent().build();
	 }
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE) 
	public ResponseEntity<Categoria> delete(@PathVariable Integer id)
	{
		 service.delete(id);
		return ResponseEntity.noContent().build();
		
		
		
	}

}

