package org.luis.proyecto.application.usecase.usuario.impl;

import org.luis.proyecto.application.usecase.usuario.CrearUsuarioUseCase;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.domain.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CrearUsuarioUseCaseImpl implements CrearUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public CrearUsuarioUseCaseImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        return usuarioRepository.save(usuario);
    }
}

