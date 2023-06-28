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
	public boolean check(ConsultaDto consulta, List<Consulta> consultas) {
		if(consulta.getHora().getMinute()!=0)
			return false;
		
		return super.checkNext(consulta, consultas);
	}

}
