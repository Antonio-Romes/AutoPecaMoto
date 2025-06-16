package com.example.AutoPecaMoto.presentation.dtos.pessoa;

import jakarta.validation.constraints.NotBlank;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnderecoDTO {
    private Long id; 

    @NotBlank(message = "Informe o campo lagradouro.")
    private String logradouro;

    @NotBlank(message = "Informe o campo numero.")
    private String numero; 
     
    private String complemento;

    @NotBlank(message = "Informe o campo bairro.")
    private String bairro ;

    @NotBlank(message = "Informe o campo cidade.")
    private String cidade ;

    @NotBlank(message = "Informe o campo estado.")
    private String estado ;

    @NotBlank(message = "Informe o campo cep.")
    private String cep ;
}
