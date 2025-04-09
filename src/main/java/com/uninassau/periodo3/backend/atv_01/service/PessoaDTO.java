package com.uninassau.periodo3.backend.atv_01.service;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PessoaDTO {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotNull
	private LocalDate dataNascimento;
	
	public int getIdade() {
		return LocalDate.now().compareTo(this.dataNascimento);
	}

}
