package com.claudiocosta.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claudiocosta.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends  JpaRepository<Cliente, Integer>{
	
	

}
