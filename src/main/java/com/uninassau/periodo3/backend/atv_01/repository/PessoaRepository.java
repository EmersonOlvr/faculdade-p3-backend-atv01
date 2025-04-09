package com.uninassau.periodo3.backend.atv_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninassau.periodo3.backend.atv_01.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
