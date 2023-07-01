package com.ifba.pweb.projeto.clinica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifba.pweb.projeto.clinica.repositorios.ConsRepo;
import com.ifba.pweb.projeto.clinica.repositorios.MedicoRepo;
import com.ifba.pweb.projeto.clinica.repositorios.PacienteRepo;

@Service
public class ConsultaService {
	
	@Autowired
	MedicoRepo medRepo;
	@Autowired
	PacienteRepo coRepo;
	@Autowired
	ConsRepo consRepo;
	
	
}
