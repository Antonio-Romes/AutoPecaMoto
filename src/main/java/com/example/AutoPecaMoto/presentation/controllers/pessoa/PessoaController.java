package com.example.AutoPecaMoto.presentation.controllers.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutoPecaMoto.application.usecases.pessoa.AllPessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.CreatePessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.DeletePessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.GetByPessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.UpdatePessoaUseCase;
import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.infrastructure.mappers.pessoa.PessoaMapper;
import com.example.AutoPecaMoto.presentation.dtos.pessoas.PessoaRequestDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoas.PessoaResponseDTO;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 



@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/pessoas")
public class PessoaController {

    private final CreatePessoaUseCase createPessoaUseCase;
    private final AllPessoaUseCase allPessoaUseCase;
    private final GetByPessoaUseCase  getByPessoaUseCase;
    private final DeletePessoaUseCase  deletePessoaUseCase;
    private final UpdatePessoaUseCase  updatePessoaUseCase;
    
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

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> getById(@PathVariable Long id) {
        Pessoa pessoas = getByPessoaUseCase.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(PessoaMapper.toPessoaResponseDTO(pessoas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
         deletePessoaUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body( null);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> update(@PathVariable Long id, @RequestBody PessoaRequestDTO dto) {
         Pessoa pessoa = updatePessoaUseCase.update(id, PessoaMapper.toPessoa(dto));
        return ResponseEntity.status(HttpStatus.OK).body( PessoaMapper.toPessoaResponseDTO(pessoa));
    }

    
}
