package com.example.AutoPecaMoto.infrastructure.mappers.pessoa;
 
import java.util.List;
import java.util.stream.Collectors;
 
import com.example.AutoPecaMoto.domain.entities.Pessoa;  
import com.example.AutoPecaMoto.presentation.dtos.pessoa.PessoaRequestDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.PessoaResponseDTO; 

public class PessoaMapper {
    
    public static Pessoa toPessoa(PessoaRequestDTO dto){
        if(dto == null)
            return null;

        Pessoa pessoa = Pessoa.builder() 
                    .nome_completo(dto.getNome_completo())
                    .apelido(dto.getApelido())
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
        
        return pessoa;
    }

    public static PessoaResponseDTO toPessoaDTO(Pessoa pessoa){
        if(pessoa == null)
            return null;
        
            return PessoaResponseDTO.builder()
                    .id(pessoa.getId())
                    .nome_completo(pessoa.getNome_completo())
                    .apelido(pessoa.getApelido())
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

   

    public static List<PessoaResponseDTO> toPessoaResponseListDTO(List<Pessoa> pessoas){

        if(pessoas == null)
            return null;

        return pessoas.stream()
                .map(pessoa -> PessoaResponseDTO.builder()
                    .id(pessoa.getId())
                    .nome_completo(pessoa.getNome_completo())
                    .apelido(pessoa.getApelido())
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
                .build())
            .collect(Collectors.toList());
    }
}
