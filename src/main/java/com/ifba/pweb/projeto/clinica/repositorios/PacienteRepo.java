package com.ifba.pweb.projeto.clinica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.pweb.projeto.clinica.entidades.Paciente;

public interface PacienteRepo extends JpaRepository<Paciente, String> {

}
