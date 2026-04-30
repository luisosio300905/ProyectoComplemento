package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.infrastructure.persistence.entity.UsuarioEntity;
import org.luis.proyecto.infrastructure.rest.request.UsuarioRequest;
import org.luis.proyecto.infrastructure.rest.response.UsuarioResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioEntity usuarioEntity) {
        Usuario usuario = new Usuario(
                usuarioEntity.getNombre(),
                usuarioEntity.getContrasenia()
        );
        usuario.setId(usuarioEntity.getId());
        return usuario;
    }

    public UsuarioEntity toUsuarioEntity(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(
                usuario.getNombre(),
                usuario.getContrasenia()
        );
        if (usuario.getId() != null) {
            usuarioEntity.setId(usuario.getId());
        }
        return usuarioEntity;
    }

    public Usuario toUsuario(UsuarioRequest usuarioRequest) {
        return new Usuario(
                usuarioRequest.nombre(),
                usuarioRequest.contrasenia()
        );
    }

    public List<Usuario> toUsuarioList(List<UsuarioEntity> usuariosEntities) {
        return usuariosEntities
                .stream()
                .map(this::toUsuario)
                .toList();
    }

    public UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre()
        );
    }

    public List<UsuarioResponse> toUsuarioResponseList(List<Usuario> usuarios) {
        return usuarios
                .stream()
                .map(this::toUsuarioResponse)
                .toList();
    }
}

