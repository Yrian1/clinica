package com.ifba.pweb.projeto.clinica.regraConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public class RegraAntecedencia extends RegradorConsulta {

	public RegraAntecedencia(RegradorConsulta next) {
		super(next);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String check(ConsultaDto consulta, List<Consulta> consultas) {
		// TODO Auto-generated method stub
		if(consulta.getData().equals(LocalDate.now())) {
			if(LocalDateTime.of(consulta.getData(), consulta.getHora()).minusMinutes(30).isBefore(LocalDateTime.now())) {
				return "Consulta deve ser agendada em ate 30 minutos antes";
			}
		}
		return super.checkNext(consulta, consultas);
	}


	


}
