package com.ifba.pweb.projeto.clinica.regraConsulta;

import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public abstract class RegradorConsulta implements Regra{
	
	RegradorConsulta next;
	
	public RegradorConsulta(RegradorConsulta next) {
			this.next = next;		
	}
	
	public abstract String check(ConsultaDto consulta, List<Consulta> consultas);
	
	public String checkNext(ConsultaDto consulta, List<Consulta> consultas) {
		if(next == null) {
			return null;
		}
		return next.check(consulta, consultas);
	}

}
