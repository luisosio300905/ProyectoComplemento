package org.luis.proyecto.application.usecase.usuario;

import org.luis.proyecto.domain.model.Usuario;

import java.util.List;

public interface ListaUsuariosUseCase {
    List<Usuario> obtenerTodos();
}

