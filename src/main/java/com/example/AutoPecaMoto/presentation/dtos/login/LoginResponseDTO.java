package com.example.AutoPecaMoto.presentation.dtos.login;
 
import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponseDTO {
    private Long id; 
    private String nome ; 
    private String senha ; 
    private boolean isAtivo ;
}
