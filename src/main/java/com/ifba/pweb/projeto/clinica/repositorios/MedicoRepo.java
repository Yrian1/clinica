package com.ifba.pweb.projeto.clinica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.pweb.projeto.clinica.entidades.Medico;

public interface MedicoRepo extends JpaRepository<Medico, String> {

}
