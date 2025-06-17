package com.example.AutoPecaMoto.presentation.dtos.pessoa;

import java.time.LocalDate; 
import java.util.List;
 
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaRequestDTO {
    
    private Long id;

    @NotBlank(message = "Informe o campo lagradouro.")
    private String nome ;

    @NotBlank(message = "Informe o campo cpf.")
	private String cpf ;

   @NotBlank(message = "Informe o campo tipo.")
	private String tipo;

      
	private LocalDate data_cadastro;

    @NotBlank(message = "Informe o campo email.")
	private String email ;

    @Valid
    private EnderecoDTO endereco;

    @Valid
    private List<TelefoneDTO> telefones;
    
}
