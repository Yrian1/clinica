package com.ifba.pweb.projeto.clinica.controladores;

import java.net.URI;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ifba.pweb.projeto.clinica.dtos.ConsultaDto;
import com.ifba.pweb.projeto.clinica.entidades.Consulta;
import com.ifba.pweb.projeto.clinica.entidades.ConsultaCancelada;
import com.ifba.pweb.projeto.clinica.entidades.Medico;
import com.ifba.pweb.projeto.clinica.entidades.Paciente;
import com.ifba.pweb.projeto.clinica.repositorios.ConsRepo;
import com.ifba.pweb.projeto.clinica.repositorios.ConsultasCanceladas;
import com.ifba.pweb.projeto.clinica.repositorios.MedicoRepo;
import com.ifba.pweb.projeto.clinica.repositorios.PacienteRepo;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
@CrossOrigin
public class ControladorConsulta {

	@Autowired
	MedicoRepo medRepo;
	@Autowired
	PacienteRepo paciRepo;
	@Autowired
	ConsRepo consRepo;
	@Autowired
	ConsultasCanceladas consCancRepo;
	
	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody @Valid ConsultaDto consulta, UriComponentsBuilder uriBuilder) {
	//	ConsultaDto consultaAprovada = new ConsultaDto(consulta);
		String response = null;
		if(consulta.getMedico_id()==null) {	
					response = consulta.check(consRepo.findByData(consulta.getData()), medRepo.findAll());
		}
		response = consulta.check(consRepo.findByData(consulta.getData()));
			//return ResponseEntity.badRequest().body(consulta);
		if(response!=null) {
			return ResponseEntity.badRequest().body(response);
		}
			
		Optional<Medico> medicoOpt = medRepo.findById(consulta.getMedico_id());

		Optional<Paciente> pacienteOpt = paciRepo.findById(consulta.getPaciente_id());
			
		Medico medico = medicoOpt.get();
		if(!medico.isEh_ativo())
			return ResponseEntity.badRequest().body("medico inativo");
		
		Paciente paciente = pacienteOpt.get();
		if(!paciente.isEh_ativo())
			return ResponseEntity.badRequest().body("paciente inativo");
		//consultaTeste.setMedico(medRepo.findById(consultaAprovada.getMedico_id()));
	
			Consulta consultaSalvar = new Consulta(medico, paciente, consulta.getData(), consulta.getHora());
			consRepo.save(consultaSalvar);
			URI uri=uriBuilder.path("/consultas/{id}").buildAndExpand(consultaSalvar.getId()).toUri();
			return ResponseEntity.created(uri).body(consulta.toString());
				
	}
	
	@GetMapping
	public List<ConsultaDto> Listar(){
		return ConsultaDto.consultaIntoConsultaDto(consRepo.findAll());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id, @RequestBody String motivo){
		
		Optional<Consulta> consultaopt = consRepo.findById(id);
		if(!consultaopt.isPresent())
			return ResponseEntity.badRequest().body("consulta inexistente");	
		Consulta consulta = consultaopt.get();
		if(LocalDateTime.of(consulta.getData(), consulta.getHora()).minusHours(24).isBefore(LocalDateTime.now())) {
			return ResponseEntity.badRequest().body("Consulta deve ser cancelada em ate 24 horas de antecedencia");
		}
		ConsultaCancelada consultaCancelada = new ConsultaCancelada(consulta, motivo);
		consCancRepo.save(consultaCancelada);
		consRepo.deleteById(id);
		return ResponseEntity.ok().body(consulta.toString());
		
	}
}
