package com.example.AutoPecaMoto.infrastructure.presistence.repositories.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AutoPecaMoto.domain.entities.Login;

public interface LoginRepositoryJPA extends JpaRepository<Login, Long> {
    Optional<Login> findByUsername(String nome);
}
