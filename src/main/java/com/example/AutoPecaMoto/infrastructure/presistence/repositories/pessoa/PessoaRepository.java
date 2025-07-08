package com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa;

import java.util.List;
 
import org.springframework.stereotype.Repository;

import com.example.AutoPecaMoto.domain.entities.Pessoa;
import com.example.AutoPecaMoto.domain.repositories.pessoa.IPessoaRepository;

import jakarta.persistence.EntityNotFoundException;
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
        
       return repository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Pessoa com id = %d não encontrado.",id))
       );
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        
       Pessoa pessoaSalve =  repository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Pessoa com id = %d não encontrado.", id))
       );

        pessoaSalve.setNome(pessoa.getNome());
        pessoaSalve.setCpf(pessoa.getCpf());
        pessoaSalve.setTipo_pessoa(pessoa.getTipo_pessoa());
        pessoaSalve.setData_cadastro(pessoa.getData_cadastro());
        pessoaSalve.setEmail(pessoa.getEmail());
        pessoaSalve.setLogradouro(pessoa.getLogradouro());
        pessoaSalve.setNumero(pessoa.getNumero());
        pessoaSalve.setComplemento(pessoa.getComplemento());
        pessoaSalve.setBairro(pessoa.getBairro());
        pessoaSalve.setCidade(pessoa.getCidade());
        pessoaSalve.setEstado(pessoa.getEstado());
        pessoaSalve.setCep(pessoa.getCep());
        pessoaSalve.setNumero_telefone(pessoa.getNumero_telefone());
        pessoaSalve.setDdd(pessoa.getDdd());
        pessoaSalve.setCargo(pessoa.getCargo());
        pessoaSalve.setSalario(pessoa.getSalario());
        pessoaSalve.setData_cadastro(pessoa.getData_cadastro());

       return repository.save(pessoaSalve);
    }

    @Override
    public void deleteById(Long id) {
        
        if(!repository.existsById(id)){
            throw new EntityNotFoundException(String.format("Pessoa com id = %d não encontrado."));
        }

         repository.deleteById(id); 
    }
    
}
