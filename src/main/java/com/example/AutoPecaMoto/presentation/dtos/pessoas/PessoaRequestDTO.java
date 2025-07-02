package com.example.AutoPecaMoto.presentation.dtos.pessoas;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.example.AutoPecaMoto.domain.entities.Endereco;
import com.example.AutoPecaMoto.domain.entities.Telefone;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    private Endereco enderecos;

    private List<Telefone> telefones;
}
