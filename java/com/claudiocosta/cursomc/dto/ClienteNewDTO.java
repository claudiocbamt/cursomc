package com.claudiocosta.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;




public class ClienteNewDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preechimento obrigatório")
	@Length(min=5, max=120, message="Minimo de 5 e maximo de 120 caracters")
	private String nome;
	@NotEmpty(message="Preechimento obrigatório")
	@Email(message="Email inválido!")
	private String email;
	private String cpfouCnpj;
	private Integer tipo;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String Telefone1;
	private String Telefone2;
	private String Telefone3;
	
	private Integer cidadeId;
	
	

	

	


	public ClienteNewDTO()
	{
		
	}





	public ClienteNewDTO(
			@NotEmpty(message = "Preechimento obrigatório") @Length(min = 5, max = 120, message = "Minimo de 5 e maximo de 120 caracters") String nome,
			@NotEmpty(message = "Preechimento obrigatório") @Email(message = "Email inválido!") String email,
			String cpfouCnpj, Integer tipo, String logradouro, String numero, String complemento, String bairro,
			String cep, String telefone1, String telefone2, String telefone3, Integer cidadeId) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpfouCnpj = cpfouCnpj;
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		Telefone1 = telefone1;
		Telefone2 = telefone2;
		Telefone3 = telefone3;
		this.cidadeId = cidadeId;
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getCpfouCnpj() {
		return cpfouCnpj;
	}





	public void setCpfouCnpj(String cpfouCnpj) {
		this.cpfouCnpj = cpfouCnpj;
	}





	public Integer getTipo() {
		return tipo;
	}





	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}





	public String getLogradouro() {
		return logradouro;
	}





	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}





	public String getNumero() {
		return numero;
	}





	public void setNumero(String numero) {
		this.numero = numero;
	}





	public String getComplemento() {
		return complemento;
	}





	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}





	public String getBairro() {
		return bairro;
	}





	public void setBairro(String bairro) {
		this.bairro = bairro;
	}





	public String getCep() {
		return cep;
	}





	public void setCep(String cep) {
		this.cep = cep;
	}





	public String getTelefone1() {
		return Telefone1;
	}





	public void setTelefone1(String telefone1) {
		Telefone1 = telefone1;
	}





	public String getTelefone2() {
		return Telefone2;
	}





	public void setTelefone2(String telefone2) {
		Telefone2 = telefone2;
	}





	public String getTelefone3() {
		return Telefone3;
	}





	public void setTelefone3(String telefone3) {
		Telefone3 = telefone3;
	}


	public Integer getCidadeId() {
		return cidadeId;
	}





	public void setCidade(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}





	
	
	
	
	

}
