package com.example.AutoPecaMoto.application.usecases.pessoa;

import org.springframework.stereotype.Service;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa.PessoaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreatePessoaUseCase {
    
    private final PessoaRepository repository;

    public Pessoa insert(Pessoa pessoa){
        return repository.save(pessoa);
    }
}
