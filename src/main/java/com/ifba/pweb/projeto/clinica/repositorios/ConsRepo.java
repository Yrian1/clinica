package com.ifba.pweb.projeto.clinica.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.pweb.projeto.clinica.entidades.Consulta;

public interface ConsRepo extends JpaRepository<Consulta, Long> {

	public List<Consulta> findByData(LocalDate data);
}
