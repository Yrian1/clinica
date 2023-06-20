package com.ifba.pweb.projeto.clinica.dtos;

import java.time.LocalDateTime;

public class ConsultaDto {
	
	private Long medico_id;
	private Long paciente_id;
	private LocalDateTime data_hora;
	
	
	public ConsultaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getMedico_id() {
		return medico_id;
	}
	public void setMedico_id(Long medico_id) {
		this.medico_id = medico_id;
	}
	public Long getPaciente_id() {
		return paciente_id;
	}
	public void setPaciente_id(Long paciente_id) {
		this.paciente_id = paciente_id;
	}
	public LocalDateTime getData_hora() {
		return data_hora;
	}
	public void setData_hora(LocalDateTime data_hora) {
		this.data_hora = data_hora;
	}
	
	

}
