package com.example.AutoPecaMoto.presentation.dtos.login;
 
import jakarta.validation.constraints.NotBlank;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class loginRequestDTO {
    
    private Long id;

    @NotBlank(message = "O campo nome é obrigatorio.")
    private String nome ;

    @NotBlank(message = "O campo senha é obrigatorio.")
    private String senha ;
 
    private boolean isAtivo ;
}
