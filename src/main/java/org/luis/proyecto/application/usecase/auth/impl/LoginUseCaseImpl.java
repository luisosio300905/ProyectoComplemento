package org.luis.proyecto.application.usecase.auth.impl;
import org.luis.proyecto.application.port.UserAuthenticationPort;
import org.luis.proyecto.application.usecase.auth.LoginUseCase;
import org.luis.proyecto.domain.model.Usuario;

public class LoginUseCaseImpl implements LoginUseCase {
    private final UserAuthenticationPort userAuthenticationPort;

    public LoginUseCaseImpl(UserAuthenticationPort userAuthenticationPort) {
        this.userAuthenticationPort = userAuthenticationPort;
    }

    @Override
    public String login(Usuario usuario) {
        return userAuthenticationPort.generateToken(usuario);
    }
}
