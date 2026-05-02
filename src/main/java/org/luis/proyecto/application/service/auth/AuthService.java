package org.luis.proyecto.application.service.auth;

import org.luis.proyecto.domain.model.Usuario;

public interface AuthService {
    String login(Usuario usuario);
}
