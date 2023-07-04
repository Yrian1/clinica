package com.ifba.pweb.projeto.clinica.regraConsulta.aprovalConsulta;

import java.util.List;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;
import com.ifba.pweb.projeto.clinica.entidades.Medico;
import com.ifba.pweb.projeto.clinica.regraConsulta.Regra;
import com.ifba.pweb.projeto.clinica.regraConsulta.RegraAntecedencia;
import com.ifba.pweb.projeto.clinica.regraConsulta.RegraHorarioDeFuncionamento;
import com.ifba.pweb.projeto.clinica.regraConsulta.RegraMedicoOcupado;
import com.ifba.pweb.projeto.clinica.regraConsulta.RegraUmaHora;

public class AprovalConsulta {
	private Regra aproval;
	public AprovalConsulta() {
		// TODO Auto-generated constructor stub
	}
	
	public String check(ConsultaDto consulta, List<Consulta> consultas, List<Medico> medicos) {
		this.aproval = new RegraHorarioDeFuncionamento(
				new RegraUmaHora(
								new RegraAntecedencia(null)));
		Regra regrarOcupado = new RegraMedicoOcupado();
		for(Medico medico : medicos){
			consulta.setMedico_id(medico.getCRM());
			if(regrarOcupado.check(consulta, consultas)==null)
				break;
				consulta.setMedico_id(null);
		}	
		return this.aproval.check(consulta, consultas);
	}
	
	public String check(ConsultaDto consulta, List<Consulta> consultas) {
		this.aproval = new RegraHorarioDeFuncionamento(
							new RegraUmaHora(
								new RegraAntecedencia(
									new RegraMedicoOcupado())));
		return this.aproval.check(consulta, consultas);
	}
	

}
