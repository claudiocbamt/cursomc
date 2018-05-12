package com.claudiocosta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiocosta.cursomc.domain.Cliente;
import com.claudiocosta.cursomc.repositories.ClienteRepository;
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

}
