package com.example.AutoPecaMoto.presentation.dtos.pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;  
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaRequestDTO {
     

    @NotBlank(message = "Informe o campo nome completo.")
    private String nome_completo ;

    @NotBlank(message = "Informe o campo apelido.")
    private String apelido ;

    @NotBlank(message = "Informe o campo cpf.")
	private String cpf ;

    @NotBlank(message = "Informe o campo tipo pessoa.")
	private String tipo_pessoa;

    LocalDate data_cadastro;

    @NotBlank(message = "Informe o campo email.")
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
