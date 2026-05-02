package org.luis.proyecto.application.port;

import org.luis.proyecto.domain.model.Usuario;

public interface UserAuthenticationPort {
    String generateToken(Usuario usuario);
}
