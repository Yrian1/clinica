package com.ifba.pweb.projeto.clinica.dtos.model;

public abstract class PessoaBasics {
	protected String nome;
	protected String email;
	protected String endereco;
	
	
	public PessoaBasics() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
