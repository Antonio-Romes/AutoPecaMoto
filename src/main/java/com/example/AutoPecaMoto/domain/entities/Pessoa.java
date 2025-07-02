package com.example.AutoPecaMoto.domain.entities;

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
    private Long id;  
  	private String nome ;
	private String cpf ;
	private String tipo;
	private LocalDate data_cadastro ;
	private String email;
}
