package com.example.AutoPecaMoto.presentation.dtos.pessoas;

import java.math.BigDecimal;
import java.time.LocalDate; 

import org.hibernate.validator.constraints.br.CPF;
 
import jakarta.validation.constraints.*; 
import lombok.*;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaRequestDTO {
   
    private Long id;  

    @NotBlank(message = "O informe o campo nome.")
    @Size(min=3, max = 250, message = "" )
  	private String nome ;

    @NotBlank(message = "O informe o campo Cpf.")
    @CPF(message = "Cpf invalido.")
	private String cpf ;

    @NotBlank(message = "O informe o campo tipo.")
	private String tipo;
	private LocalDate data_cadastro ;

    @NotBlank(message = "O informe o campo email.")
    @Email(message = "Formato do e-mail está invalido!", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
	private String email;
    
     
    @NotBlank(message = "O informe o campo logradouro.") 
    private String logradouro;

    @NotBlank(message = "O informe o campo numero.") 
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
