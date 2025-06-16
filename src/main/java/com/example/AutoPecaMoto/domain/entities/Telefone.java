package com.example.AutoPecaMoto.domain.entities;

import jakarta.persistence.*;
import lombok.*; 
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "telefones")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = true, length = 50)
    private String tipo;

    @Column(nullable = true, length = 20)
    private String numero; 

    @Column(nullable = false, length = 2)
    private String ddd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
