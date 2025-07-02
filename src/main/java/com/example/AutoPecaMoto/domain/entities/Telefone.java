package com.example.AutoPecaMoto.domain.entities;

import jakarta.persistence.*; 
import lombok.*; 

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="telefones") 
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pessoa_id;
    private String tipo;
    private String numero;
    private String ddd; 
}
