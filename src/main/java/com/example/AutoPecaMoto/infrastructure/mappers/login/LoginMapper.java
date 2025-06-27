package com.example.AutoPecaMoto.infrastructure.mappers.login;

import com.example.AutoPecaMoto.domain.entities.Login;
import com.example.AutoPecaMoto.presentation.dtos.login.LoginResponseDTO;
import com.example.AutoPecaMoto.presentation.dtos.login.loginRequestDTO;

public class LoginMapper {
    
    public static Login toLogin(loginRequestDTO dto){

        if(dto == null)
            return null;

       return Login.builder()
                        .id(dto.getId())
                        .nome(dto.getNome())
                        .senha(dto.getSenha())
                        .isAtivo(dto.isAtivo())
                        .build();
    }

    public static LoginResponseDTO toLoginResponseDTO(Login login){
        
        if(login == null)
            return null;

        return LoginResponseDTO.builder()
                .id(login.getId())
                .nome(login.getNome())
                .senha(login.getSenha())
                .isAtivo(login.isAtivo())
                .build();
    }
}
