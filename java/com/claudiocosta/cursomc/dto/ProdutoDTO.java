package com.claudiocosta.cursomc.dto;

import java.io.Serializable;


import com.claudiocosta.cursomc.domain.Produto;

public class ProdutoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	private String nome;
	private Double preco;
	
	public ProdutoDTO()
	{
		
	}
	
	public ProdutoDTO(Produto obj) {
		super();
		 Id = obj.getId();
	     nome = obj.getNome();
		 preco = obj.getPreco();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	
	


}
