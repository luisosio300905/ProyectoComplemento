package org.luis.proyecto.application.service.auth.impl;

import org.luis.proyecto.application.service.auth.AuthService;
import org.luis.proyecto.application.usecase.auth.LoginUseCase;
import org.luis.proyecto.domain.model.Usuario;

public class AuthServiceImpl implements AuthService {
    private final LoginUseCase loginUseCase;

    public AuthServiceImpl(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Override
    public String login(Usuario usuario) {
        return loginUseCase.login(usuario);
    }
}
