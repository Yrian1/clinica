package com.ifba.pweb.projeto.clinica.regraConsulta;

import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public class RegraMedicoOcupado extends RegradorConsulta {

	public RegraMedicoOcupado(RegradorConsulta next) {
		super(next);
		// TODO Auto-generated constructor stub
	}
	
	public RegraMedicoOcupado() {
		// TODO Auto-generated constructor stub
		super(null);
	}
	@Override
	public String check(ConsultaDto consulta, List<Consulta> consultas) {
		//System.out.println("regra medico ocupado: antes do check");
		if(consulta.getMedico_id()==null) {
			return "nao ha medicos disponiveis no horario";
		}
		for(Consulta consultaAgendadas : consultas) {
			if(consultaAgendadas.getMedico().getCRM() == consulta.getMedico_id()) {
				if(consulta.getHora().getHour() == consultaAgendadas.getHora().getHour()) {
					return "medico ocupado";
				}
			}
		}
		System.out.println("regra medico ocupado: depois do check");
		return checkNext(consulta, consultas);
	}

}
