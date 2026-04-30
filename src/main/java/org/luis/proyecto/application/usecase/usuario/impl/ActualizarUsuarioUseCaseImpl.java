package org.luis.proyecto.application.usecase.usuario.impl;

import org.luis.proyecto.application.usecase.usuario.ActualizarUsuarioUseCase;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.domain.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ActualizarUsuarioUseCaseImpl implements ActualizarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public ActualizarUsuarioUseCaseImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        Usuario usuarioActualizar = usuarioRepository.findById(id).orElseThrow();
        actualizarUsuario(usuarioActualizar, usuario);
        return usuarioRepository.save(usuarioActualizar);
    }

    @Override
    public Usuario actualizar(String nombre, Usuario usuario) {
        Usuario usuarioActualizar = usuarioRepository.findByNombre(nombre).orElseThrow();
        actualizarUsuario(usuarioActualizar, usuario);
        return usuarioRepository.save(usuarioActualizar);
    }

    private void actualizarUsuario(Usuario usuario1, Usuario usuario2) {
        usuario1.setNombre(usuario2.getNombre());
        usuario1.setContrasenia(passwordEncoder.encode(usuario2.getContrasenia()));
    }
}

