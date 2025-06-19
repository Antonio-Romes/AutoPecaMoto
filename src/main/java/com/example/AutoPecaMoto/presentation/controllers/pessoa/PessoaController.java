package com.example.AutoPecaMoto.presentation.controllers.pessoa;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.example.AutoPecaMoto.application.usecases.pessoa.CreatePessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.DeletePessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.GetAllPessoasUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.GetPessoaUseCase;
import com.example.AutoPecaMoto.application.usecases.pessoa.UpdatePessoaUseCase;
import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.domain.exeptions.HandlerNotFoundException;
import com.example.AutoPecaMoto.infrastructure.mappers.pessoa.PessoaMapper;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.PessoaRequestDTO;
import com.example.AutoPecaMoto.presentation.dtos.pessoa.PessoaResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
 
 


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pessoas")
public class PessoaController {
    
    private final CreatePessoaUseCase createUseCase;
    private final GetPessoaUseCase getPessoa;
    private final GetAllPessoasUseCase getAllPessoa;
    private final UpdatePessoaUseCase updatePessoaUseCase;
    private final DeletePessoaUseCase deletePessoaUseCase;

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

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> getAll() {
         List<Pessoa> pessoas = getAllPessoa.selects();
         return ResponseEntity.status(HttpStatus.OK).body(PessoaMapper.toPessoaResponseListDTO(pessoas)); 
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> update(@PathVariable Long id, @RequestBody PessoaRequestDTO dto) {
        
       if(!updatePessoaUseCase.existsById(id)){
              throw new HandlerNotFoundException("Pessoa não encontrada com id: " + id);
        } 
        
        Pessoa pessoa = updatePessoaUseCase.update(PessoaMapper.toPessoa(dto));
        return ResponseEntity.status(HttpStatus.OK).body(PessoaMapper.toPessoaDTO(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        
        if(!deletePessoaUseCase.existsById(id)){
              throw new HandlerNotFoundException("Pessoa não encontrada com id: " + id);
        }

        deletePessoaUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    
}
