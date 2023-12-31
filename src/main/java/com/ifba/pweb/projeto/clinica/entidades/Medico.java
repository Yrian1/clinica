package com.ifba.pweb.projeto.clinica.entidades;

import com.ifba.pweb.projeto.clinica.entidades.model.PessoaForm;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity(name = "medicos")
public class Medico extends PessoaForm{

	private String email;
	@Id
	@NotNull
	private String crm;
	private boolean eh_ativo;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

	
	public Medico() {
		super();
		this.eh_ativo = true;
		// TODO Auto-generated constructor stub
	}



	public Medico(String email, String cRM, boolean eh_ativo, Especialidade especialidade) {
		super();
		this.email = email;
		crm = cRM;
		this.eh_ativo = eh_ativo;
		this.especialidade = especialidade;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCRM() {
		return crm;
	}

	public void setCRM(String cRM) {
		crm = cRM;
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

	
	
	
}
