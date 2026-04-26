package org.luis.proyecto.application.service.usuario;

import org.luis.proyecto.domain.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario crear(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    Usuario actualizar(String nombre, Usuario usuario);
    void eliminar(Integer id);
    Usuario obtenerUsuario(Integer id);
    Usuario obtenerPorNombre(String nombre);
    List<Usuario> obtenerTodos();
}
