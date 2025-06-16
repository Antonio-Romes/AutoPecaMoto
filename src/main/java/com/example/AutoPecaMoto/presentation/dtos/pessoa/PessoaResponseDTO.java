package com.example.AutoPecaMoto.presentation.dtos.pessoa;

import java.time.LocalDate;
import java.util.List;
 

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data 
public class PessoaResponseDTO {
    private Long id; 
    private String nome ; 
	private String cpf ; 
	private String tipo; 
	private LocalDate data_cadastro; 
	private String email ; 
    private EnderecoDTO endereco; 
    private List<TelefoneDTO> telefones;
}
