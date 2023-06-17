package com.ifba.pweb.projeto.clinica.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "medicos")
public class Medico {
	private String nome;
	private String email;
	@Id
	private Long CRM;
	private boolean eh_ativo;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@OneToOne
	private Endereco endereco;
	
	public Medico() {
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

	public Long getCRM() {
		return CRM;
	}

	public void setCRM(Long cRM) {
		CRM = cRM;
	}

	public boolean isEh_ativo() {
		return eh_ativo;
	}

	public void setEh_ativo(boolean eh_ativo) {
		this.eh_ativo = eh_ativo;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
