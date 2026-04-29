package org.luis.proyecto.infrastructure.rest;

import org.luis.proyecto.application.service.usuario.UsuarioService;
import org.luis.proyecto.infrastructure.mapper.UsuarioMapper;
import org.luis.proyecto.infrastructure.rest.request.UsuarioRequest;
import org.luis.proyecto.infrastructure.rest.response.UsuarioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<UsuarioResponse>> getUsuarios() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioMapper.toUsuarioResponseList(usuarioService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<UsuarioResponse> createUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioMapper.toUsuarioResponse(
                        usuarioService.crear(usuarioMapper.toUsuario(usuarioRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuario(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioMapper.toUsuarioResponse(usuarioService.obtenerUsuario(id)));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<UsuarioResponse> getUsuarioPorNombre(@PathVariable String nombre) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioMapper.toUsuarioResponse(usuarioService.obtenerPorNombre(nombre)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioMapper.toUsuarioResponse(
                        usuarioService.actualizar(id, usuarioMapper.toUsuario(usuarioRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

