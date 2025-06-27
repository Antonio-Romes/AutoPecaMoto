package com.example.AutoPecaMoto.presentation.controllers.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutoPecaMoto.application.usecases.login.AutenticarLoginUseCase;
import com.example.AutoPecaMoto.application.usecases.login.SaveLoginUseCase;
import com.example.AutoPecaMoto.domain.entities.Login; 
import com.example.AutoPecaMoto.infrastructure.mappers.login.LoginMapper; 
import com.example.AutoPecaMoto.presentation.dtos.login.LoginResponseDTO;
import com.example.AutoPecaMoto.presentation.dtos.login.loginRequestDTO; 

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    
    private final AutenticarLoginUseCase autenticarUseCase;
    private final SaveLoginUseCase saveUseCase;

    @GetMapping("/autenticar")
     public ResponseEntity<LoginResponseDTO> autenticar(@Valid @RequestBody loginRequestDTO dto){ 
        Login login = autenticarUseCase.autenticar(LoginMapper.toLogin(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(LoginMapper.toLoginResponseDTO(login));
    }
    
    @PostMapping
     public ResponseEntity<LoginResponseDTO> salvar(@Valid @RequestBody loginRequestDTO dto){ 
        Login login = saveUseCase.save(LoginMapper.toLogin(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(LoginMapper.toLoginResponseDTO(login));
    }
}
