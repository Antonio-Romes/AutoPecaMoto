package com.example.AutoPecaMoto.presentation.dtos.pessoas;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.*;
 
 
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaResponseDTO {
	
    private Long id;  
  	private String nome ; 
	private String cpf ; 
	private String tipo;
	private LocalDate data_cadastro ; 
	private String email; 
    private String logradouro; 
    private String numero; 
    private String complemento; 
    private String bairro; 
    private String cidade; 
    private String estado; 
    private String cep; 
    private String numero_telefone; 
    private String ddd; 
    private String cargo; 
    private BigDecimal salario;    
    private LocalDate data_Contratacao;  
}
