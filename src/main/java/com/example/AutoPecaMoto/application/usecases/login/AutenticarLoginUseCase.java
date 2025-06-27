package com.example.AutoPecaMoto.application.usecases.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AutoPecaMoto.domain.entities.Login;
import com.example.AutoPecaMoto.infrastructure.presistence.repositories.login.LoginRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AutenticarLoginUseCase{//implements UserDetailsService {
    
    private final LoginRepository repository;
    public Login autenticar(Login login){
        return repository.autenticar(login);
    }
    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //      Login login = repository.findByUsername(username)
    //             .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

    // }
}
