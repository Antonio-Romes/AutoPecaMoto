package com.example.AutoPecaMoto.infrastructure.mappers.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.AutoPecaMoto.domain.entities.Endereco;
import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.domain.entities.Telefone;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.EnderecoDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.PessoaRequestDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.PessoaResponseDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.TelefoneDTO;

public class PessoaMapper {
    
    public static Pessoa toPessoa(PessoaRequestDTO dto){
        if(dto == null)
            return null;

        Pessoa pessoa = Pessoa.builder()
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .cpf(dto.getCpf())
                    .tipo(dto.getTipo())
                    .data_cadastro(dto.getData_cadastro())
                    .email(dto.getEmail())
                    .endereco(toEndereco(dto.getEndereco()))
                    .build();

        if(dto.getTelefones() != null){
            pessoa.setTelefones(dto.getTelefones().stream()
                .map(tel -> Telefone.builder()
                    .id(tel.getId())
                    .numero(tel.getNumero())
                    .ddd(tel.getDdd())
                    .tipo(tel.getTipo())
                    .pessoa(pessoa)
                    .build())
                    .collect(Collectors.toList())    
            );
        }

        return pessoa;
    }

    public static PessoaResponseDTO toPessoaDTO(Pessoa pessoa){
        if(pessoa == null)
            return null;
        
            return PessoaResponseDTO.builder()
                    .id(pessoa.getId())
                    .nome(pessoa.getNome())
                    .cpf(pessoa.getCpf())
                    .tipo(pessoa.getTipo())
                    .data_cadastro(pessoa.getData_cadastro())
                    .email(pessoa.getEmail())
                    .endereco(toEnderecoDTO(pessoa.getEndereco()))
                    .telefones(toTelefoneDTOList(pessoa.getTelefones()))
                    .build();
    }

    public static Endereco toEndereco(EnderecoDTO dto){ 
        if(dto == null)
            return null;

        return Endereco.builder()
            .id(dto.getId())
            .logradouro(dto.getLogradouro())
            .numero(dto.getNumero())
            .complemento(dto.getComplemento())
            .bairro(dto.getBairro())
            .cidade(dto.getCidade())
            .estado(dto.getEstado())
            .cep(dto.getCep())
            .build();
    }

    public static EnderecoDTO toEnderecoDTO (Endereco endereco){
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public static List<TelefoneDTO> toTelefoneDTOList(List<Telefone> telefones){
        if(telefones == null)
            return new ArrayList<>();

        return telefones.stream()
                .map(tel -> TelefoneDTO.builder()
                    .id(tel.getId())
                    .numero(tel.getNumero())
                    .ddd(tel.getDdd())
                    .tipo(tel.getTipo()) 
                    .build())
                .collect(Collectors.toList()) ;
    }

    public static List<PessoaResponseDTO> toPessoaResponseListDTO(List<Pessoa> pessoas){

        if(pessoas == null)
            return null;

        return pessoas.stream()
                .map(pessoa -> PessoaResponseDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .cpf(pessoa.getCpf())
                .tipo(pessoa.getTipo())
                .data_cadastro(pessoa.getData_cadastro())
                .email(pessoa.getEmail())
                .endereco(toEnderecoDTO(pessoa.getEndereco()))
                .telefones(toTelefoneDTOList(pessoa.getTelefones()))
                .build())
            .collect(Collectors.toList());
    }
}
