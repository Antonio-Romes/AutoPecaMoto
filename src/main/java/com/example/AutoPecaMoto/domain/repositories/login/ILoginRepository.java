package com.example.AutoPecaMoto.domain.repositories.login;
 

import com.example.AutoPecaMoto.domain.entities.Login; 

public interface ILoginRepository {
 
     Login save(Login login);
     Login autenticar(Login login);
}
