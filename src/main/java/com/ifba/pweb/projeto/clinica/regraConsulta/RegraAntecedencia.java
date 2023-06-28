package com.ifba.pweb.projeto.clinica.regraConsulta;

import java.time.LocalTime;
import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public class RegraAntecedencia extends RegradorConsulta {

	public RegraAntecedencia(RegradorConsulta next) {
		super(next);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean check(ConsultaDto consulta, List<Consulta> consultas) {
		// TODO Auto-generated method stub
		if(consulta.getHora().plusMinutes(30).isAfter(LocalTime.now())) {
			return false;
		}
		return super.checkNext(consulta, consultas);
	}


	


}
