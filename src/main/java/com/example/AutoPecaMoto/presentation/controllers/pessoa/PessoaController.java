package com.example.AutoPecaMoto.presentation.controllers.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutoPecaMoto.application.usecases.pessoa.CreatePessoaUseCase;
import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.infrastructure.mappers.pessoa.PessoaMapper;
import com.example.AutoPecaMoto.presentation.dtos.pessoas.PessoaRequestDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoas.PessoaResponseDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/pessoas")
public class PessoaController {

    private final CreatePessoaUseCase createPessoaUseCase;
    
    @PostMapping()
    public ResponseEntity<PessoaResponseDTO> postMethodName(@RequestBody PessoaRequestDTO dto) { 
        Pessoa pessoa = createPessoaUseCase.insert(PessoaMapper.toPessoa(dto)); 
        return ResponseEntity.status(HttpStatus.CREATED).body(PessoaMapper.toPessoaResponseDTO(pessoa));
    }
    
}
