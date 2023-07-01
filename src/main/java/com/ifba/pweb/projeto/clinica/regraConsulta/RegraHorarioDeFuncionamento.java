package com.ifba.pweb.projeto.clinica.regraConsulta;

import java.time.DayOfWeek;
import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public class RegraHorarioDeFuncionamento extends RegradorConsulta{
	private final int HoraInicial = 7;
	private final int HoraFinal = 19;
	public RegraHorarioDeFuncionamento(RegradorConsulta next) {
		super(next);
	}

	
	
	public String check(ConsultaDto consulta , List<Consulta> consultas) {
		
		if(consulta.getData().getDayOfWeek() == DayOfWeek.SUNDAY) {
				return "nao e possivel agendar aos domingos";
		}
		if(consulta.getHora().getHour() < HoraInicial || consulta.getHora().getHour() > HoraFinal) {
			return "nao e possivel agendar fora do horario de funcionamento";
		}
	
		return super.checkNext(consulta, consultas);
	}
}
