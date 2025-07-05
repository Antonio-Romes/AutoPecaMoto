package com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Repository;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.domain.repositories.pessoa.IPessoaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PessoaRepository implements IPessoaRepository {
    
    private final PessoaRepositoryJPA repository;

    @Override
    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @Override
    public List<Pessoa> getAll() {
        return repository.findAll();
    }

    @Override
    public Pessoa getById(Long id) {
        
       throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
