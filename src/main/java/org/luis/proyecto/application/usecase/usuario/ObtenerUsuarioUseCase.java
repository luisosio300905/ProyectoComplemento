package org.luis.proyecto.application.usecase.usuario;

import org.luis.proyecto.domain.model.Usuario;

public interface ObtenerUsuarioUseCase {
    Usuario obtenerUsuario(Integer id);
    Usuario obtenerPorNombre(String nombre);
}

