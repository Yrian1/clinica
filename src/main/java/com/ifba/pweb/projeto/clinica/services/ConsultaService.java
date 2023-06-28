package com.ifba.pweb.projeto.clinica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifba.pweb.projeto.clinica.repositorios.ConsRepo;
import com.ifba.pweb.projeto.clinica.repositorios.medicoRepo;
import com.ifba.pweb.projeto.clinica.repositorios.pacienteRepo;

@Service
public class ConsultaService {
	
	@Autowired
	medicoRepo medRepo;
	@Autowired
	pacienteRepo coRepo;
	@Autowired
	ConsRepo consRepo;
	
	
}
