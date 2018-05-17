package com.claudiocosta.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.claudiocosta.cursomc.domain.Categoria;
import com.claudiocosta.cursomc.dto.CategoriaDTO;
import com.claudiocosta.cursomc.repositories.CategoriaRepository;
import com.claudiocosta.cursomc.services.exception.DataIntegrityException;
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
		Categoria newObj = Buscar(obj.getId());
		updateData(newObj,obj);
		
		return repo.save(newObj);
	}
	
	public void delete(Integer id)
	{
		//obj.setId(null);
		Buscar(id);
		try
		{
			 repo.deleteById(id);
		}	
		catch (DataIntegrityViolationException e)
		{
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}
	
	public List<Categoria> BuscarTodos(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer Page, Integer linesPerPage, String orderBy, String direction )
	{
		PageRequest pageRequest = PageRequest.of(Page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	public Categoria fromDTO(CategoriaDTO objDTO)
	{
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}
	
private void updateData(Categoria newObj, Categoria obj) {
		
		newObj.setNome(obj.getNome());
		
	}
}

	   

