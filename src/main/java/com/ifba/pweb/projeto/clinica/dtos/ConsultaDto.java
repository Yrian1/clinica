package com.ifba.pweb.projeto.clinica.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ifba.pweb.projeto.clinica.entidades.Consulta;
import com.ifba.pweb.projeto.clinica.entidades.Medico;
import com.ifba.pweb.projeto.clinica.regraConsulta.aprovalConsulta.AprovalConsulta;

import jakarta.validation.constraints.NotNull;

public class ConsultaDto {
	
	
	private Long id;
	private Long medico_id;
	@NotNull(message = "paciente_id nao pode ser nullo")
	private Long paciente_id;
	@NotNull(message = "hora nao pode ser nullo")
	private LocalTime hora;
	@NotNull(message = "data nao pode ser nullo")
	private LocalDate data;
	
	
	public ConsultaDto() {
		super();
		// TODO Auto-generated constructor stub
	
	}
	public ConsultaDto(ConsultaDto consulta) {
		super();				
		this.hora = consulta.getHora();
		this.data = consulta.getData();
		this.medico_id = consulta.getMedico_id();
		this.paciente_id = consulta.getPaciente_id();	
	}
	
	public ConsultaDto(Consulta consulta) {
		super();	
		this.id=consulta.getId();
		this.hora = consulta.getHora();
		this.data = consulta.getData();
		this.medico_id = consulta.getMedico().getCRM();
		this.paciente_id = consulta.getPaciente().getCPF();	
	}
	
	@Override
	public String toString() {
		return "ConsultaDto [medico_id=" + medico_id + ", paciente_id=" + paciente_id + ", hora=" + hora + ", data="
				+ data + "]";
	}
	public String check(List<Consulta> consultas) {
		//System.out.println(this.toString());
		return new AprovalConsulta().check(this, consultas);
			
	}
	
	public String check(List<Consulta> consultas, List<Medico> medicos) {
		//System.out.println(this.toString());
		return new AprovalConsulta().check(this, consultas, medicos);
			
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
	public Consulta IntoConsultaEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<ConsultaDto> consultaIntoConsultaDto(List<Consulta> consultas) {
		// TODO Auto-generated method stub
		return consultas.stream().map(ConsultaDto::new).collect(Collectors.toList());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
