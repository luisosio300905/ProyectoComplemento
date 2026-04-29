package org.luis.proyecto.infrastructure.security;

import org.luis.proyecto.infrastructure.persistence.entity.UsuarioEntity;
import org.luis.proyecto.infrastructure.persistence.repository.JpaUsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final JpaUsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(JpaUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository
                .findByNombre(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new User(
                usuario.getNombre(),
                usuario.getContrasenia(),
                Collections.emptyList()
        );
    }
}
