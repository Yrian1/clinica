package com.ifba.pweb.projeto.clinica.entidades;

import com.ifba.pweb.projeto.clinica.entidades.model.PessoaForm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "pacientes")
public class Paciente extends PessoaForm{
	private String email;
	@Id
	@NotNull
	@NotBlank
	private String cpf;
	private boolean eh_ativo;

	
	public Paciente() {
		super();
		this.eh_ativo = true;
		// TODO Auto-generated constructor stub
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



	public String getCPF() {
		return cpf;
	}



	public void setCPF(String cPF) {
		cpf = cPF;
	}


	
}
