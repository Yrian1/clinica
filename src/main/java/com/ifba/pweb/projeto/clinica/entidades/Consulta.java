package com.ifba.pweb.projeto.clinica.entidades;

import java.time.LocalDate;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "consultas")
@Table(uniqueConstraints = {@UniqueConstraint(name = "UniquePacienteData", columnNames = {"paciente", "data"})})
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name ="medico")
	private Medico medico;
	@ManyToOne
	@JoinColumn(name ="paciente")
	private Paciente paciente;
	private LocalDate data;
	private LocalTime hora;
	
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Consulta(Medico medico, Paciente paciente, LocalDate data, LocalTime hora) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
		this.hora = hora;
	}
	
	
	
}
