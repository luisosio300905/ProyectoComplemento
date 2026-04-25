package org.luis.proyecto.application.usecase.usuario.impl;

import org.luis.proyecto.application.usecase.usuario.CrearUsuarioUseCase;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.domain.repository.UsuarioRepository;

public class CrearUsuarioUseCaseImpl implements CrearUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public CrearUsuarioUseCaseImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}

