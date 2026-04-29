package org.luis.proyecto.application.usecase.usuario.impl;

import org.luis.proyecto.application.usecase.usuario.ListaUsuariosUseCase;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.domain.repository.UsuarioRepository;

import java.util.List;

public class ListaUsuariosUseCaseImpl implements ListaUsuariosUseCase {
    private final UsuarioRepository usuarioRepository;

    public ListaUsuariosUseCaseImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
}

