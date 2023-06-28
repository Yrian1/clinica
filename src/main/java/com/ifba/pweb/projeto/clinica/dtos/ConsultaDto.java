package com.ifba.pweb.projeto.clinica.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ifba.pweb.projeto.clinica.entidades.Consulta;
import com.ifba.pweb.projeto.clinica.regraConsulta.aprovalConsulta.AprovalConsulta;

public class ConsultaDto {
	
	private Long medico_id;
	private Long paciente_id;
	private LocalTime hora;
	private LocalDate data;
	
	
	public ConsultaDto() {
		super();
		// TODO Auto-generated constructor stub
	
	}
	public ConsultaDto(ConsultaDto consulta, List<Consulta> consultas) {
		super();
		
		if(new AprovalConsulta().check(consulta, consultas)) {
			this.hora = consulta.getHora();
			this.data = consulta.getData();
			this.medico_id = consulta.getMedico_id();
			this.paciente_id = consulta.getPaciente_id();
		}
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

	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Consulta getIntoConsultaEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<ConsultaDto> consultaIntoConsultaDto(List<Consulta> findAll) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
