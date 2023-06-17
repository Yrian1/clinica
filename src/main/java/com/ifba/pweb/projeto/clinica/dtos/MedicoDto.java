package com.ifba.pweb.projeto.clinica.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.ifba.pweb.projeto.clinica.entidades.Especialidade;
import com.ifba.pweb.projeto.clinica.entidades.Medico;

public class MedicoDto {
	
	private String nome;
	private String email;
	private Long CRM;
	private Especialidade especialidade;
	
	
	public MedicoDto(Medico medico) {
		super();
		this.nome = medico.getNome();
		this.email = medico.getEmail();
		CRM = medico.getCRM();
		this.especialidade = medico.getEspecialidade();
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
	public Long getCrm() {
		return CRM;
	}
	public void setCrm(Long crm) {
		CRM = crm;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	public static List<MedicoDto> medicoIntoMedicoDto(List<Medico> medicos){
		return medicos.stream().map(MedicoDto::new).collect(Collectors.toList());
	}

}
