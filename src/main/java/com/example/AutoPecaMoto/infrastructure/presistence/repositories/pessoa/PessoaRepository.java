package com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa;

import java.util.List;
 
import org.springframework.stereotype.Repository;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.domain.repositories.pessoa.IPessoaRepository;
import com.example.AutoPecaMoto.infrastructure.mappers.pessoa.PessoaMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PessoaRepository implements IPessoaRepository {

    private final PessoaRepositoryJPA pessoaRepositoryJPA;
    @Override
    public Pessoa save(Pessoa pessoa) {
         return pessoaRepositoryJPA.save(pessoa);
    }

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepositoryJPA.findAll();
    }

    @Override
    public Pessoa getById(Long id) {
       return pessoaRepositoryJPA.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com id: " + id));
 
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        
       if(!pessoaRepositoryJPA.existsById(id)){
              throw new EntityNotFoundException("Pessoa não encontrada com id: " + id);
        } 

        return pessoaRepositoryJPA.save(pessoa);
    }

    @Override
    public void deleteById(Long id) {

        if(!pessoaRepositoryJPA.existsById(id)){
              throw new EntityNotFoundException("Pessoa não encontrada com id: " + id);
        }
        
        pessoaRepositoryJPA.deleteById(id);
    }
    
}
