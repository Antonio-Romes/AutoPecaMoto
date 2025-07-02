package com.example.AutoPecaMoto.presentation.dtos.pessoas;

import java.time.LocalDate;
import java.util.List; 

import com.example.AutoPecaMoto.domain.entities.Endereco;
import com.example.AutoPecaMoto.domain.entities.Telefone; 

public class PessoaResponseDTO {
    private Long id;   
  	private String nome ; 
	private String cpf ; 
	private String tipo;
	private LocalDate data_cadastro ; 
	private String email; 
    private Endereco enderecos; 
    private List<Telefone> telefones;
}
