package com.claudiocosta.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.claudiocosta.cursomc.domain.Cliente;

import com.claudiocosta.cursomc.dto.ClienteDTO;
import com.claudiocosta.cursomc.repositories.ClienteRepository;
import com.claudiocosta.cursomc.services.exception.DataIntegrityException;
import com.claudiocosta.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	public Cliente Buscar(Integer id)
	{
		Optional<Cliente> obj = repo.findById(id); 
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado! id : " +id + " Tipo:  " + Cliente.class.getName()));
		
	}
	
	
	
	public Cliente update(Cliente obj)
	{
		//obj.setId(null);
		Cliente newObj = Buscar(obj.getId());
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
			throw new DataIntegrityException("Não é possivel excluir um cliente que tenha pedidos");
		}
	}
	
	public List<Cliente> BuscarTodos(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer Page, Integer linesPerPage, String orderBy, String direction )
	{
		PageRequest pageRequest = PageRequest.of(Page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	public Cliente fromDTO(ClienteDTO objDTO)
	{
		
		
		return new Cliente(objDTO.getId(),objDTO.getNome(),objDTO.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}
