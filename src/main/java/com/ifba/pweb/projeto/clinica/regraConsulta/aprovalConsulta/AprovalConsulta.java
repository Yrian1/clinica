package com.ifba.pweb.projeto.clinica.regraConsulta.aprovalConsulta;

import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;
import com.ifba.pweb.projeto.clinica.regraConsulta.Regra;
import com.ifba.pweb.projeto.clinica.regraConsulta.RegraAntecedencia;
import com.ifba.pweb.projeto.clinica.regraConsulta.RegraHorarioDeFuncionamento;
import com.ifba.pweb.projeto.clinica.regraConsulta.RegraMedicoOcupado;
import com.ifba.pweb.projeto.clinica.regraConsulta.RegraUmaHora;

public class AprovalConsulta {
	private Regra aproval;
	public AprovalConsulta() {
		// TODO Auto-generated constructor stub
		this.aproval = new RegraHorarioDeFuncionamento(
							new RegraUmaHora(
									new RegraMedicoOcupado(
											new RegraAntecedencia(null))));
		

	}
	
	public boolean check(ConsultaDto consulta, List<Consulta> consultas) {
		return this.aproval.check(consulta, consultas);
	}

}
