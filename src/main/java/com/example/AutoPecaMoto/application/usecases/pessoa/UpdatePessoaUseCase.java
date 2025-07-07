package com.example.AutoPecaMoto.application.usecases.pessoa;

import org.springframework.stereotype.Service;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa.PessoaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdatePessoaUseCase {
    
    private final PessoaRepository repository;

    public Pessoa update(Long id, Pessoa pessoa){
        return repository.update(id, pessoa);
    }
}
