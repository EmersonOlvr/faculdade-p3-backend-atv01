package com.uninassau.periodo3.backend.atv_01.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uninassau.periodo3.backend.atv_01.service.PessoaDTO;
import com.uninassau.periodo3.backend.atv_01.service.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/{id}")
	public PessoaDTO getPessoa(@PathVariable Long id) {
		return this.service.get(id);
	}
	
	@PostMapping
	public ResponseEntity<PessoaDTO> savePessoa(@RequestBody @Valid PessoaDTO pessoa) {
		return new ResponseEntity<>(this.service.save(pessoa), HttpStatus.CREATED);
	}

}
