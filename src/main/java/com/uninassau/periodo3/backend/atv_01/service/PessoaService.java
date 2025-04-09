package com.uninassau.periodo3.backend.atv_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.uninassau.periodo3.backend.atv_01.domain.Pessoa;
import com.uninassau.periodo3.backend.atv_01.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public PessoaDTO convert(Pessoa pessoa) {
		return PessoaDTO.builder()
						.id(pessoa.getId() != null ? pessoa.getId() : null)
						.nome(pessoa.getNome())
						.cpf(pessoa.getCpf())
						.dataNascimento(pessoa.getDataNascimento())
						.build();
	}
	
	public Pessoa unconvert(PessoaDTO pessoa) {
		return Pessoa.builder()
					.id(pessoa.getId() != null ? pessoa.getId() : null)
					.nome(pessoa.getNome())
					.cpf(pessoa.getCpf())
					.dataNascimento(pessoa.getDataNascimento())
					.build();
	}
	
	public PessoaDTO get(Long id) {
		return this.convert(this.repository.findById(id)
								.orElseThrow(() -> new ResponseStatusException(
										HttpStatus.NOT_FOUND, 
										"Não foi possível encontrar pessoa com o id: " + id
								))
		);
	}

	public PessoaDTO save(PessoaDTO pessoa) {
		return this.convert(
				this.repository.save(this.unconvert(pessoa))
		);
	}

}
