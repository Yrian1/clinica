package com.ifba.pweb.projeto.clinica.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.pweb.projeto.clinica.dtos.MedicoDto;
import com.ifba.pweb.projeto.clinica.entidades.Medico;
import com.ifba.pweb.projeto.clinica.entidades.model.PessoaForm;
import com.ifba.pweb.projeto.clinica.repositorios.MedicoRepo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/medicos")
public class ControladorMedico {
	
	@Autowired
	MedicoRepo medRepo;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid Medico medico) {
		System.out.println(medico);
		medRepo.save(medico);
		
	}
	
	@GetMapping
	public List<MedicoDto> Listar(){
		return MedicoDto.medicoIntoMedicoDto(medRepo.findAll());
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody PessoaForm medicoForm) {
		
		Optional<Medico> projetoOpt = medRepo.findById(id);
		if(!projetoOpt.isPresent()){
			return;
		}
			Medico medico = projetoOpt.get();
			medico.setNome(medicoForm.getNome());
			medico.setTelefone(medicoForm.getTelefone());
			medico.setEndereco(medicoForm.getEndereco());
			medRepo.save(medico);
			
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		
		Optional<Medico> medicoOpt = medRepo.findById(id);
		if(!medicoOpt.isPresent()){
			return;
		}
			
			Medico medico = medicoOpt.get();
			medico.setEh_ativo(false);
			//medRepo.delete(medico);
	}
	
}
