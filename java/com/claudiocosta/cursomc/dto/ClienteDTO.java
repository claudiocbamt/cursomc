package com.claudiocosta.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.claudiocosta.cursomc.domain.Cliente;

public class ClienteDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message="Preechimento obrigatório")
	@Length(min=5, max=120, message="Minimo de 5 e maximo de 120 caracters")
	private String nome;
	@NotEmpty(message="Preechimento obrigatório")
	@Email(message="Email inválido!")
	private String email;
	
	

	

	public ClienteDTO()
	{
		
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email=obj.getEmail();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}


}
