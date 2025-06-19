package com.example.AutoPecaMoto.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*; 
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pessoas")
public class Pessoa {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String nome ;

    @Column(nullable = false, length = 14)
	private String cpf ;

    @Column(nullable = false, length = 20)
	private String tipo;

    @Column(nullable = false) 
	private LocalDate data_cadastro;

    @Column(nullable = false, unique = true, length = 250)
	private String email ;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();
    
    public void addTelefone(Telefone telefone){
        telefones.add(telefone);
        telefone.setPessoa(this);
    } 
}
