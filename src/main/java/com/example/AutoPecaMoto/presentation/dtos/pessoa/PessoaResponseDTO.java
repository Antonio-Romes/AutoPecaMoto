package com.example.AutoPecaMoto.presentation.dtos.pessoa;

import java.math.BigDecimal;
import java.time.LocalDate; 
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data 
public class PessoaResponseDTO {

     private Long id;  
    private String nome_completo ; 
    private String apelido ; 
	private String cpf ; 
	private String tipo_pessoa; 
    LocalDate data_cadastro; 
	private String email ; 
    private String logradouro;  
    private String numero;  
    private String complemento;  
    private String bairro ;  
    private String cidade ;  
    private String estado ;  
    private String cep ;   
    private String numero_telefone;   
    private String ddd;  
    private String cargo ;  
    private BigDecimal salario;  
    private LocalDate data_Contratacao;
}
