package com.ifba.pweb.projeto.clinica.entidades;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "pacientes")
public class Paciente {
	private String nome;
	private String email;
	@Id
	private Long CPF;
	private boolean eh_ativo;
	@OneToOne
	private Endereco endereco;
	
	public Paciente() {
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


	public boolean isEh_ativo() {
		return eh_ativo;
	}

	public void setEh_ativo(boolean eh_ativo) {
		this.eh_ativo = eh_ativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
