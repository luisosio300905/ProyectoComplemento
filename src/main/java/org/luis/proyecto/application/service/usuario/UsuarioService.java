package org.luis.proyecto.application.service.usuario;

import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.infrastructure.rest.request.UsuarioRequest;

import java.util.List;

public interface UsuarioService {
    Usuario crear(UsuarioRequest usuario);
    Usuario actualizar(Integer id, UsuarioRequest usuario);
    void eliminar(Integer id);
    Usuario obtenerUsuario(Integer id);
    Usuario obtenerPorNombre(String nombre);
    List<Usuario> obtenerTodos();
}
