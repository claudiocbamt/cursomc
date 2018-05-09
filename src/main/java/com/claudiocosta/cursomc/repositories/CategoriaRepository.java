package com.claudiocosta.cursomc.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.claudiocosta.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends  JpaRepository<Categoria, Integer>{
	
	

}
