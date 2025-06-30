package com.example.AutoPecaMoto.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate; 

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
    private String nome_completo ;

    @Column(nullable = false, length = 20)
    private String apelido ;

    @Column(nullable = false, unique = true, length = 14)
	private String cpf ;

    @Column(nullable = false, length = 20)
	private String tipo_pessoa;

    @Column(nullable = false) 
	private LocalDate data_cadastro;

    @Column(nullable = false,  length = 250)
	private String email ;

    @Column(nullable = true, length = 250)
    private String logradouro;

    @Column(nullable = true, length = 20)
    private String numero;

    @Column(nullable = false, length = 100)
    private String complemento;

    @Column(nullable = true, length = 100)
    private String bairro ;

    @Column(nullable = true, length = 100)
    private String cidade ;

    @Column(nullable = true, length = 2)
    private String estado ;

    @Column(nullable = true, length = 10)
    private String cep ; 

    @Column(nullable = true, length = 20)
    private String numero_telefone; 

    @Column(nullable = true, length = 2)
    private String ddd;

    @Column(nullable = false, length = 25)
    private String cargo ;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;

    @Column(nullable = false)
    private LocalDate data_contratacao;
   
}
