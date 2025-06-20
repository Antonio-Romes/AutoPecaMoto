package com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.AutoPecaMoto.domain.entities.Pessoa;

public interface PessoaRepositoryJPA extends JpaRepository<Pessoa, Long>{
    
}
