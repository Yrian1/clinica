package com.ifba.pweb.projeto.clinica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.pweb.projeto.clinica.entidades.ConsultaCancelada;

public interface ConsultasCanceladas extends JpaRepository<ConsultaCancelada, Long> {

}
