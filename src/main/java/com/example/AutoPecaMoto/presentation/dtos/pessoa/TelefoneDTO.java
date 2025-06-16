package com.example.AutoPecaMoto.presentation.dtos.pessoa;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TelefoneDTO { 
   
    private Long id;  

    @NotBlank(message = "Informe o campo tipo.")
    private String tipo; 

    @NotBlank(message = "Informe o campo numero.")
    private String numero;  

    @NotBlank(message = "Informe o campo DDD.")
    private String ddd;

    
}
