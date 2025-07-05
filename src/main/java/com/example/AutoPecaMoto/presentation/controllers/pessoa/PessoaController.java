package com.example.AutoPecaMoto.presentation.controllers.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutoPecaMoto.application.usecases.pessoa.AllPessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.CreatePessoaUseCase;
import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.infrastructure.mappers.pessoa.PessoaMapper;
import com.example.AutoPecaMoto.presentation.dtos.pessoas.PessoaRequestDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoas.PessoaResponseDTO;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping; 



@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/pessoas")
public class PessoaController {

    private final CreatePessoaUseCase createPessoaUseCase;
    private final AllPessoaUseCase allPessoaUseCase;
    
    @PostMapping
    public ResponseEntity<PessoaResponseDTO> save(@RequestBody PessoaRequestDTO dto) { 
        Pessoa pessoa = createPessoaUseCase.insert(PessoaMapper.toPessoa(dto)); 
        return ResponseEntity.status(HttpStatus.CREATED).body(PessoaMapper.toPessoaResponseDTO(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> getAll() {
        List<Pessoa> pessoas = allPessoaUseCase.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(PessoaMapper.toListPessoaResponseDTO(pessoas));
    }
    
    
}
