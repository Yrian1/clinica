package com.ifba.pweb.projeto.clinica.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.ifba.pweb.projeto.clinica.dtos.model.PessoaBasics;
import com.ifba.pweb.projeto.clinica.entidades.Especialidade;
import com.ifba.pweb.projeto.clinica.entidades.Medico;

import jakarta.validation.constraints.NotNull;

public class MedicoDto extends PessoaBasics{
	
	@NotNull(message = "CRM nao pode ser nulo")
	private String CRM;
	private Especialidade especialidade;
	
	
	public MedicoDto(Medico medico) {
		super();
		this.nome = medico.getNome();
		this.email = medico.getEmail();
		this.CRM = medico.getCRM();
		this.especialidade = medico.getEspecialidade();
		this.endereco = medico.getEndereco();
	}
	
	public String getCrm() {
		return CRM;
	}
	public void setCrm(String crm) {
		CRM = crm;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	public static List<MedicoDto> medicoIntoMedicoDto(List<Medico> medicos){
		return medicos.stream().filter(temp -> temp.isEh_ativo())
						.map(MedicoDto::new)
							.collect(Collectors.toList());
		
	}

}

