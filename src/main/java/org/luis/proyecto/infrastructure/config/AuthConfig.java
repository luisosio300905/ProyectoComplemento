package org.luis.proyecto.infrastructure.config;

import org.luis.proyecto.application.port.UserAuthenticationPort;
import org.luis.proyecto.application.service.auth.AuthService;
import org.luis.proyecto.application.service.auth.impl.AuthServiceImpl;
import org.luis.proyecto.application.usecase.auth.LoginUseCase;
import org.luis.proyecto.application.usecase.auth.impl.LoginUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

    @Bean
    public LoginUseCase loginUseCase(UserAuthenticationPort userAuthenticationPort) {
        return new LoginUseCaseImpl(userAuthenticationPort);
    }

    @Bean
    public AuthService authService(LoginUseCase loginUseCase) {
        return new AuthServiceImpl(loginUseCase);
    }

}
