package com.ifba.pweb.projeto.clinica.regraConsulta;

import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public class RegraMedicoOcupado extends RegradorConsulta {

	public RegraMedicoOcupado(RegradorConsulta next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(ConsultaDto consulta, List<Consulta> consultas) {
		
		for(Consulta consultaAgendadas : consultas) {
			if(consultaAgendadas.getMedico().getCRM() == consulta.getMedico_id()) {
				if(consulta.getHora().getHour() == consultaAgendadas.getHora().getHour()) {
					return false;
				}
			}
		}
		return checkNext(consulta, consultas);
	}

}
