package com.example.AutoPecaMoto.application.usecases.pessoa;

import org.springframework.stereotype.Service;

import com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa.PessoaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeletePessoaUseCase {
    
    private final PessoaRepository repository;

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
