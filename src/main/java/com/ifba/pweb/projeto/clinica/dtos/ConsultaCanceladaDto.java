package com.ifba.pweb.projeto.clinica.dtos;

import com.ifba.pweb.projeto.clinica.entidades.Consulta;

import jakarta.validation.constraints.NotNull;

public class ConsultaCanceladaDto extends ConsultaDto {
	
	@NotNull
	private String motivo; 

	
	public ConsultaCanceladaDto() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaCanceladaDto(ConsultaDto consulta, String motivo) {
		super(consulta);
		this.motivo = motivo;
		// TODO Auto-generated constructor stub
	}

	public ConsultaCanceladaDto(Consulta consulta, String motivo) {
		super(consulta);
		this.motivo = motivo;
		// TODO Auto-generated constructor stub
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
