package com.ifba.pweb.projeto.clinica.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "consultas")
public class Consulta {
	
	@Id
	private Long id;
	
	@OneToOne
	@JoinColumn(name ="medico_id")
	private Medico medico;
	@OneToOne
	@JoinColumn(name ="paciente_id")
	private Paciente paciente;
	private LocalDateTime data_hora;
	
	
	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public LocalDateTime getData_hora() {
		return data_hora;
	}
	public void setData_hora(LocalDateTime data_hora) {
		this.data_hora = data_hora;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
