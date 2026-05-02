package org.luis.proyecto.application.usecase.auth;

import org.luis.proyecto.domain.model.Usuario;

public interface LoginUseCase {

    String login(Usuario usuario);
}
