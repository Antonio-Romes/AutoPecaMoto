package com.example.AutoPecaMoto.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
 
import jakarta.persistence.*; 
import lombok.*; 

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="pessoas") 
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "tipo_pessoa", nullable = false, length = 20)
    private String tipo_pessoa;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate data_cadastro;

    @Column(name = "email", nullable = false,length = 100)
    private String email;

    @Column(name = "logradouro", nullable = false, length = 150)
    private String logradouro;

    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    @Column(name = "complemento", length = 50)
    private String complemento;

    @Column(name = "bairro",   length = 50)
    private String bairro;

    @Column(name = "cidade",   length = 50)
    private String cidade;

    @Column(name = "estado",  length = 2)
    private String estado;

    @Column(name = "cep",  length = 8)
    private String cep;

    @Column(name = "numero_telefone", length = 9)
    private String numero_telefone;

    @Column(name = "ddd", length = 2)
    private String ddd;

    @Column(name = "cargo", length = 50)
    private String cargo;

    @Column(name = "salario", precision = 10, scale = 2)
    private BigDecimal salario;   

    @Column(name = "data_contratacao")
    private LocalDate data_Contratacao;
}
