package com.ifba.pweb.projeto.clinica.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;
import com.ifba.pweb.projeto.clinica.entidades.Medico;
import com.ifba.pweb.projeto.clinica.entidades.Paciente;
import com.ifba.pweb.projeto.clinica.repositorios.ConsRepo;
import com.ifba.pweb.projeto.clinica.repositorios.medicoRepo;
import com.ifba.pweb.projeto.clinica.repositorios.pacienteRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ControladorConsulta {

	@Autowired
	medicoRepo medRepo;
	@Autowired
	pacienteRepo paciRepo;
	@Autowired
	ConsRepo consRepo;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid ConsultaDto consulta) {
		ConsultaDto consultaAprovada = new ConsultaDto(consulta, consRepo.findByData(consulta.getData()));
		
		Optional<Medico> medico = medRepo.findById(consultaAprovada.getMedico_id());
		
		Optional<Paciente> paciente = paciRepo.findById(consultaAprovada.getPaciente_id());
		

		//consultaTeste.setMedico(medRepo.findById(consultaAprovada.getMedico_id()));
		if(consultaAprovada!=null) {
			consRepo.save(new Consulta(medico.get(), paciente.get(), consultaAprovada.getData(), consultaAprovada.getHora()));
		}		
	}
	
	@GetMapping
	public List<ConsultaDto> Listar(){
		return ConsultaDto.consultaIntoConsultaDto(consRepo.findAll());
	}
}
