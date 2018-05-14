package com.claudiocosta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiocosta.cursomc.domain.Categoria;
import com.claudiocosta.cursomc.repositories.CategoriaRepository;
import com.claudiocosta.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	public Categoria Buscar(Integer id)
	{
		Optional<Categoria> obj = repo.findById(id); 
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado! id : " +id + " Tipo:  " + Categoria.class.getName()));
		
	}

	
	public Categoria insert(Categoria obj)
	{
		obj.setId(null);
		return repo.save(obj);
	}
	public Categoria update(Categoria obj)
	{
		//obj.setId(null);
		Buscar(obj.getId());
		return repo.save(obj);
	}
}
