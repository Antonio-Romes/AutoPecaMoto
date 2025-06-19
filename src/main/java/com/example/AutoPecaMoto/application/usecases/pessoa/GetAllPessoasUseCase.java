package com.example.AutoPecaMoto.application.usecases.pessoa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa.PessoaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetAllPessoasUseCase {
    
    private final PessoaRepository pessoaRepository;

    public List<Pessoa> selects(){
        return pessoaRepository.getAll();
    }
}
