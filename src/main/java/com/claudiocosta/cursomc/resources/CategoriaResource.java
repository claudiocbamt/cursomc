package com.claudiocosta.cursomc.resources;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claudiocosta.cursomc.domain.Categoria;

@Controller
@RestController
@RequestMapping(value="categorias")

public class CategoriaResource {
	
	@RequestMapping(method= RequestMethod.GET) 
	public List<Categoria> Listar()
	{
		Categoria cat1 = new Categoria(1,"Informática");
		Categoria cat2 = new Categoria(2,"Escritório");
				
				List<Categoria> lista = new ArrayList<>();
						lista.add(cat1);
				        lista.add(cat2);
				
		
		return lista;
		
	}
	

}