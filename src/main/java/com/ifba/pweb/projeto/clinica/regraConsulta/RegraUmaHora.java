package com.ifba.pweb.projeto.clinica.regraConsulta;


import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public class RegraUmaHora extends RegradorConsulta {

	public RegraUmaHora(RegradorConsulta next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String check(ConsultaDto consulta, List<Consulta> consultas) {
		
		if(consulta.getHora().getMinute()!=0)
			return "consulta deve ser agendada em no padrao: \"hh:00:00\"";
	
		return super.checkNext(consulta, consultas);
	}

}
