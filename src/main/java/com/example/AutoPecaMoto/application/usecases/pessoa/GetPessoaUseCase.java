package com.example.AutoPecaMoto.application.usecases.pessoa;

import org.springframework.stereotype.Service;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa.PessoaRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class GetPessoaUseCase {
    
    private final PessoaRepository pessoaRepository;

    public Pessoa select(Long id){
        return pessoaRepository.getById(id);
    }
}
