package com.ifba.pweb.projeto.clinica.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.ifba.pweb.projeto.clinica.dtos.model.PessoaBasics;
import com.ifba.pweb.projeto.clinica.entidades.Paciente;

import jakarta.validation.constraints.NotNull;

public class PacienteDto extends PessoaBasics{
	
	@NotNull(message = "cpf nao pode ser nulo")
	private String CPF;
	
	
	
	public PacienteDto(Paciente paciente) {
		super();
		this.nome = paciente.getNome();
		this.email = paciente.getEmail();
		this.setCPF(paciente.getCPF());
		this.endereco = paciente.getEndereco();
	}

	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public static List<PacienteDto> pacienteIntoPacienteDto(List<Paciente> pacientes){
		return pacientes.stream().filter(temp -> temp.isEh_ativo())
						.map(PacienteDto::new)
							.collect(Collectors.toList());
		
	}

}

