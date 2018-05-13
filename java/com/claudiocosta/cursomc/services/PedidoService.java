package com.claudiocosta.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudiocosta.cursomc.domain.Pedido;
import com.claudiocosta.cursomc.repositories.PedidoRepository;
import com.claudiocosta.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	public Pedido Buscar(Integer id)
	{
		Optional<Pedido> obj = repo.findById(id); 
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado! id : " +id + " Tipo:  " + Pedido.class.getName()));
		
	}

}
