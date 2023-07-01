package com.ifba.pweb.projeto.clinica.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;

@Entity(name = "canceladas")
public class ConsultaCancelada extends ConsultaBase {
	

	public String motivo;
	
	
	public ConsultaCancelada() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaCancelada(Medico medico, Paciente paciente, LocalDate data, LocalTime hora, String motivo) {
		super(medico, paciente, data, hora);
		// TODO Auto-generated constructor stub
		this.motivo = motivo;
	}
	public ConsultaCancelada(Consulta consulta, String motivo) {
		super(consulta.getMedico(), consulta.getPaciente(), consulta.getData(), consulta.getHora());
		// TODO Auto-generated constructor stub
		this.motivo = motivo;
	}

	
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
