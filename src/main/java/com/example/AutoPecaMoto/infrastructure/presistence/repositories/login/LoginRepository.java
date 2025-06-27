package com.example.AutoPecaMoto.infrastructure.presistence.repositories.login;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.AutoPecaMoto.domain.entities.Login;
import com.example.AutoPecaMoto.domain.repositories.login.ILoginRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class LoginRepository implements ILoginRepository {
    
    private final LoginRepositoryJPA repository;

    @Override
    public Login save(Login login) {
       return repository.save(login);
    }

    @Override
    public Login autenticar(Login login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticar'");
    }

    public Optional<Login> findByUsername(String nome){
        return repository.findByUsername(nome);
    }
     
}
