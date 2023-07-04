package com.ifba.pweb.projeto.clinica.controladores;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.pweb.projeto.clinica.dtos.PacienteDto;
import com.ifba.pweb.projeto.clinica.entidades.Paciente;
import com.ifba.pweb.projeto.clinica.entidades.model.PessoaForm;
import com.ifba.pweb.projeto.clinica.repositorios.PacienteRepo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class ControladorPaciente {
	
	@Autowired
	PacienteRepo pacienteRepo;
	
	@PostMapping
	public ResponseEntity<Paciente> cadastrar(@Valid @RequestBody  Paciente paciente) {
		
		pacienteRepo.save(paciente);
		return ResponseEntity.ok().body(paciente);
	
		
		
		
	}
	
	@GetMapping
	public Iterable<PacienteDto> Listar(){
		return PacienteDto.pacienteIntoPacienteDto(pacienteRepo.findAll());
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable String id, @RequestBody PessoaForm medicoForm) {
		
		Optional<Paciente> pacienteOpt = pacienteRepo.findById(id);
		if(!pacienteOpt.isPresent()){
			return;
		}
			Paciente paciente = pacienteOpt.get();
			paciente.setNome(medicoForm.getNome());
			paciente.setTelefone(medicoForm.getTelefone());
			paciente.setEndereco(medicoForm.getEndereco());
			pacienteRepo.save(paciente);
			
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> deletar(@PathVariable String id) {
		
		Optional<Paciente> pacienteOpt = pacienteRepo.findById(id);
		if(!pacienteOpt.isPresent()){
			return ResponseEntity.badRequest().body("nao encontrado");
		}
			
			Paciente paciente = pacienteOpt.get();
			paciente.setEh_ativo(false);
			pacienteRepo.save(paciente);
		return ResponseEntity.accepted().body("deletado");
	}
	
}
