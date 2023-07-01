package com.ifba.pweb.projeto.clinica.regraConsulta;

import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public class RegraInativo extends RegradorConsulta {

	public RegraInativo(RegradorConsulta next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String check(ConsultaDto consulta, List<Consulta> consultas) {
		// TODO Auto-generated method stub
		return "";
	}

}
