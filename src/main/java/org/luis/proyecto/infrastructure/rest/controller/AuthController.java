package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.auth.AuthService;
import org.luis.proyecto.application.service.usuario.UsuarioService;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.infrastructure.mapper.UsuarioMapper;
import org.luis.proyecto.infrastructure.rest.request.UsuarioRequest;
import org.luis.proyecto.infrastructure.rest.response.UsuarioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final AuthService authService;

    public AuthController(UsuarioService usuarioService, UsuarioMapper usuarioMapper, AuthService authService) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.login(usuarioMapper.toUsuario(usuarioRequest)));
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
