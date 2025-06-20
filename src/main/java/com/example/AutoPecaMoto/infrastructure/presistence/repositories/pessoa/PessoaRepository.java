package com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa;

import java.util.List; 
import org.springframework.stereotype.Repository; 

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.domain.exeptions.CpfUniqueViolationExecption;
import com.example.AutoPecaMoto.domain.exeptions.EmailUniqueViolationExecption;
import com.example.AutoPecaMoto.domain.exeptions.HandlerNotFoundException;
import com.example.AutoPecaMoto.domain.repositories.pessoa.IPessoaRepository; 
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PessoaRepository implements IPessoaRepository {

    private final PessoaRepositoryJPA repositoryJPA;
    @Override
    public Pessoa save(Pessoa pessoa) { 
        if(validCpf(pessoa.getCpf()) != null)
            throw new CpfUniqueViolationExecption(String.format("O CPF '%s' já foi cadastrado.",pessoa.getCpf())); 
        
        if(validEmail(pessoa.getEmail()) != null)
            throw new EmailUniqueViolationExecption(String.format("O Email '%s' já foi cadastrado.",pessoa.getEmail())); 

        return repositoryJPA.save(pessoa); 
    }

    @Override
    public List<Pessoa> getAll() {
        return repositoryJPA.findAll();
    }

    @Override
    public Pessoa getById(Long id) {
       return repositoryJPA.findById(id)
                .orElseThrow(() -> new HandlerNotFoundException(String.format("Cliente id = %s não encontrado no sistema", id)));
    }

    @Override
    public Pessoa update(Pessoa pessoa) { 
       if(validCpf(pessoa.getCpf()) != null)
            throw new CpfUniqueViolationExecption(String.format("O CPF '%s' já foi cadastrado.",pessoa.getCpf()));
        
         if(validEmail(pessoa.getEmail()) != null)
            throw new EmailUniqueViolationExecption(String.format("O Email '%s' já foi cadastrado.",pessoa.getEmail()));
            
        return repositoryJPA.save(pessoa);
         
    }

    @Override
    public void deleteById(Long id) {

        if(!repositoryJPA.existsById(id)){
              throw new HandlerNotFoundException("Pessoa não encontrada com id: " + id);
        }
        
        repositoryJPA.deleteById(id);
    }

    public boolean existsById(Long id){
        return repositoryJPA.existsById(id);
    }

    private Pessoa validCpf(String cpf){
        return repositoryJPA.getPessoaByCpf(cpf);
    }
    private Pessoa validEmail(String email){
        return repositoryJPA.getPessoaByEmail(email);
    }
    
}
