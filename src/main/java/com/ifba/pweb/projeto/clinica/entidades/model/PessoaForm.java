package com.ifba.pweb.projeto.clinica.entidades.model;


import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class PessoaForm {
	private String nome;
	private String telefone;
	private String endereco;
	
	
	public PessoaForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
