package com.ifba.pweb.projeto.clinica.entidades;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "consultas")
@Table(uniqueConstraints = {@UniqueConstraint(name = "UniquePacienteData", columnNames = {"paciente", "data"})})
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Consulta extends ConsultaBase {

	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consulta(Medico medico, Paciente paciente, LocalDate data, LocalTime hora) {
		super(medico, paciente, data, hora);
		// TODO Auto-generated constructor stub
	}

	
}
