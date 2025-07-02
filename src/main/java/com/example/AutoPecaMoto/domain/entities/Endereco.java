package com.example.AutoPecaMoto.domain.entities;

import jakarta.persistence.*; 
import lombok.*; 

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="enderecos") 
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pessoa_id;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado ;
    private String cep;
}
