package org.luis.proyecto.application.usecase.usuario;

import org.luis.proyecto.domain.model.Usuario;

public interface ActualizarUsuarioUseCase {
    Usuario actualizar(Integer id, Usuario usuario);
    Usuario actualizar(String nombre, Usuario usuario);
}

