package org.luis.proyecto.application.usecase.usuario.impl;

import org.luis.proyecto.application.usecase.usuario.ObtenerUsuarioUseCase;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.domain.repository.UsuarioRepository;

public class ObtenerUsuarioUseCaseImpl implements ObtenerUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public ObtenerUsuarioUseCaseImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario obtenerUsuario(Integer id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public Usuario obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre).orElseThrow();
    }
}

