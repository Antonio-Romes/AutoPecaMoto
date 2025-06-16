package com.example.AutoPecaMoto.domain.entities;

import jakarta.persistence.*;
import lombok.*; 

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "enderecos")
public class Endereco {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; 

  @Column(nullable = true, length = 250)
  private String logradouro;

  @Column(nullable = true, length = 20)
  private String numero;

  @Column(nullable = true, length = 100)
  private String complemento;

  @Column(nullable = true, length = 100)
  private String bairro ;

  @Column(nullable = true, length = 100)
  private String cidade ;

  @Column(nullable = true, length = 2)
  private String estado ;

  @Column(nullable = true, length = 10)
  private String cep ;
}
