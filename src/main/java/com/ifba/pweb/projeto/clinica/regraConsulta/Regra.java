package com.ifba.pweb.projeto.clinica.regraConsulta;

import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public interface Regra {
	public String check(ConsultaDto consulta, List<Consulta> consultas);
	
}
