package org.luis.proyecto.infrastructure.security;

import org.luis.proyecto.application.usecase.usuario.CrearUsuarioUseCase;
import org.luis.proyecto.application.usecase.usuario.ObtenerUsuarioUseCase;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.infrastructure.persistence.entity.UsuarioEntity;
import org.luis.proyecto.infrastructure.persistence.repository.JpaUsuarioRepository;
import org.luis.proyecto.infrastructure.rest.request.UsuarioRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private JpaUsuarioRepository usuarioRepository;

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
