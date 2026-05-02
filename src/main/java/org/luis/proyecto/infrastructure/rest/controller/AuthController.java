package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.usuario.UsuarioService;
import org.luis.proyecto.domain.exception.InvalidCredentialsException;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.infrastructure.mapper.UsuarioMapper;
import org.luis.proyecto.infrastructure.rest.request.UsuarioRequest;
import org.luis.proyecto.infrastructure.rest.response.UsuarioResponse;
import org.luis.proyecto.infrastructure.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;
    private final UsuarioMapper usuarioMapper;

    public AuthController(AuthenticationManager authenticationManager, UsuarioService usuarioService, JwtUtil jwtUtil, UsuarioMapper usuarioMapper) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioRequest usuarioRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            usuarioRequest.nombre(),
                            usuarioRequest.contrasenia()
                    )
            ); //mover esta logica a la capa de aplicacion (use case)
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(jwtUtil.generateToken(userDetails.getUsername()));
        } catch (AuthenticationException ex) {
            throw new InvalidCredentialsException("Usuario o contraseña incorrectos");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> registerUser(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.crear(usuarioMapper.toUsuario(usuarioRequest));
        UsuarioResponse usuarioResponse = usuarioMapper.toUsuarioResponse(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioResponse);
    }
}
