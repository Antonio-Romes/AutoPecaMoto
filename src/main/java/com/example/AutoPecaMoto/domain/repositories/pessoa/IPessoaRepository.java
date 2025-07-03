package com.example.AutoPecaMoto.domain.repositories.pessoa;

import java.util.List;

import com.example.AutoPecaMoto.domain.entities.Pessoa;

public interface IPessoaRepository {
    
    Pessoa save(Pessoa pessoa);
    List<Pessoa> getAll();
    Pessoa getById(Long id);
    Pessoa update(Long id, Pessoa pessoa);
    void deleteById(Long id);
}
