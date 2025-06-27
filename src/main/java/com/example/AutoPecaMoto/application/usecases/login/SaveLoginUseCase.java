package com.example.AutoPecaMoto.application.usecases.login;

import org.springframework.stereotype.Service;

import com.example.AutoPecaMoto.domain.entities.Login; 
import com.example.AutoPecaMoto.infrastructure.presistence.repositories.login.LoginRepositoryJPA;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SaveLoginUseCase {

    private final LoginRepositoryJPA repositoryJPA;
    public Login save(Login login) {
       return repositoryJPA.save(login);
    }
    
}
