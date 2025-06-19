package com.example.AutoPecaMoto.presentation.controllers.pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.example.AutoPecaMoto.application.usecases.pessoa.CreatePessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.GetPessoaUseCase;
import com.example.AutoPecaMoto.domain.entities.Pessoa; 
import com.example.AutoPecaMoto.infrastructure.mappers.pessoa.PessoaMapper;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.PessoaRequestDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.PessoaResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pessoas")
public class PessoaController {
    
    private final CreatePessoaUseCase createUseCase;
    private final GetPessoaUseCase getPessoa;

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> create(@Valid @RequestBody PessoaRequestDTO dto){
         
        Pessoa pessoa = createUseCase.insert(PessoaMapper.toPessoa(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(PessoaMapper.toPessoaDTO(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> getById(@PathVariable Long id) {
        Pessoa pessoa = getPessoa.select(id);
        return ResponseEntity.status(HttpStatus.OK).body(PessoaMapper.toPessoaDTO(pessoa));
    }
    
}
