package com.example.AutoPecaMoto.infrastructure.presistence.repositories.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.AutoPecaMoto.domain.entities.Pessoa;

public interface PessoaRepositoryJPA extends JpaRepository<Pessoa, Long>{
    @Query("Select p From Pessoa p where p.cpf = :cpf")
    Pessoa getPessoaByCpf(@Param("cpf") String cpf);

    @Query("Select p From Pessoa p where p.email = :email")
    Pessoa getPessoaByEmail(@Param("email") String email);
}
