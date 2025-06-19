package com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa;

import java.util.List;
 
import org.springframework.stereotype.Repository;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.domain.exeptions.HandlerNotFoundException;
import com.example.AutoPecaMoto.domain.repositories.pessoa.IPessoaRepository; 
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
                .orElseThrow(() -> new HandlerNotFoundException(String.format("Cliente id = %s não encontrado no sistema", id)));
 
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        
       if(!pessoaRepositoryJPA.existsById(id)){
              throw new HandlerNotFoundException("Pessoa não encontrada com id: " + id);
        } 

        return pessoaRepositoryJPA.save(pessoa);
    }

    @Override
    public void deleteById(Long id) {

        if(!pessoaRepositoryJPA.existsById(id)){
              throw new HandlerNotFoundException("Pessoa não encontrada com id: " + id);
        }
        
        pessoaRepositoryJPA.deleteById(id);
    }
    
}
