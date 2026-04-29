package org.luis.proyecto.application.usecase.usuario.impl;

import org.luis.proyecto.application.usecase.usuario.EliminarUsuarioUseCase;
import org.luis.proyecto.domain.repository.UsuarioRepository;

public class EliminarUsuarioUseCaseImpl implements EliminarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public EliminarUsuarioUseCaseImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

