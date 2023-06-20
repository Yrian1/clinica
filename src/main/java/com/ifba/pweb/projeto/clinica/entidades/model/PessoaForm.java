package com.ifba.pweb.projeto.clinica.entidades.model;

import com.ifba.pweb.projeto.clinica.entidades.Endereco;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public class PessoaForm {
	private String nome;
	private String telefone;
	@OneToOne
	private Endereco endereco;
	
	
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
