package com.example.AutoPecaMoto.infrastructure.mappers.pessoa;

import java.util.List; 
import java.util.stream.Collectors;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.presentation.dtos.pessoas.PessoaRequestDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoas.PessoaResponseDTO;

public class PessoaMapper {
    
    public static Pessoa toPessoa(PessoaRequestDTO dto){

       return Pessoa.builder()
                            .nome(dto.getNome())
                            .cpf(dto.getCpf())
                            .tipo_pessoa(dto.getTipo_pessoa())
                            .data_cadastro(dto.getData_cadastro())
                            .email(dto.getEmail())
                            .logradouro(dto.getLogradouro())
                            .numero(dto.getNumero())
                            .complemento(dto.getComplemento())
                            .bairro(dto.getBairro())
                            .cidade(dto.getCidade())
                            .estado(dto.getEstado())
                            .cep(dto.getCep())
                            .numero_telefone(dto.getNumero_telefone())
                            .ddd(dto.getDdd())
                            .cargo(dto.getCargo())
                            .salario(dto.getSalario())
                            .data_cadastro(dto.getData_cadastro())
                        .build();
    }

    public static PessoaResponseDTO toPessoaResponseDTO(Pessoa pessoa){
        
        return PessoaResponseDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .cpf(pessoa.getCpf())
                .tipo_pessoa(pessoa.getTipo_pessoa())
                .data_cadastro(pessoa.getData_cadastro())
                .email(pessoa.getEmail())
                .logradouro(pessoa.getLogradouro())
                .numero(pessoa.getNumero())
                .complemento(pessoa.getComplemento())
                .bairro(pessoa.getBairro())
                .cidade(pessoa.getCidade())
                .estado(pessoa.getEstado())
                .cep(pessoa.getCep())
                .numero_telefone(pessoa.getNumero_telefone())
                .ddd(pessoa.getDdd())
                .cargo(pessoa.getCargo())
                .salario(pessoa.getSalario())
                .data_cadastro(pessoa.getData_cadastro())
            .build();
    }

    public static List<PessoaResponseDTO> toListPessoaResponseDTO(List<Pessoa> pessoas){
        
        return pessoas.stream()
                 .map(pessoa -> PessoaResponseDTO.builder()
                     .id(pessoa.getId())
                    .nome(pessoa.getNome())
                    .cpf(pessoa.getCpf())
                    .tipo_pessoa(pessoa.getTipo_pessoa())
                    .data_cadastro(pessoa.getData_cadastro())
                    .email(pessoa.getEmail())
                    .logradouro(pessoa.getLogradouro())
                    .numero(pessoa.getNumero())
                    .complemento(pessoa.getComplemento())
                    .bairro(pessoa.getBairro())
                    .cidade(pessoa.getCidade())
                    .estado(pessoa.getEstado())
                    .cep(pessoa.getCep())
                    .numero_telefone(pessoa.getNumero_telefone())
                    .ddd(pessoa.getDdd())
                    .cargo(pessoa.getCargo())
                    .salario(pessoa.getSalario())
                    .data_cadastro(pessoa.getData_cadastro())
                    .build()
                 ).collect(Collectors.toList());  
                 
                 
    }
}

 