package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.application.port.UserAuthenticationPort;
import org.luis.proyecto.domain.exception.InvalidCredentialsException;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.infrastructure.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationAdapter implements UserAuthenticationPort {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserAuthenticationAdapter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String generateToken(Usuario usuario) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            usuario.getNombre(),
                            usuario.getContrasenia()
                    )
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtUtil.generateToken(userDetails.getUsername());
        } catch (AuthenticationException ex) {
            throw new InvalidCredentialsException("Usuario o contraseña incorrectos");
        }
    }
}
