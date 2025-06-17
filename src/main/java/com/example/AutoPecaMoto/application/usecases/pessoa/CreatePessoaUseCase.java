package com.example.AutoPecaMoto.application.usecases.pessoa;

import org.springframework.stereotype.Service;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa.PessoaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreatePessoaUseCase {
    private final PessoaRepository pessoaRepository;

    public Pessoa insert(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
}
