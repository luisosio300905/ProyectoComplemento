package org.luis.proyecto.application.service.usuario.impl;

import org.luis.proyecto.application.usecase.usuario.*;
import org.luis.proyecto.application.service.usuario.UsuarioService;
import org.luis.proyecto.domain.model.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final ActualizarUsuarioUseCase actualizarUsuarioUseCase;
    private final EliminarUsuarioUseCase eliminarUsuarioUseCase;
    private final ListaUsuariosUseCase listaUsuariosUseCase;
    private final ObtenerUsuarioUseCase obtenerUsuarioUseCase;

    public UsuarioServiceImpl(CrearUsuarioUseCase crearUsuarioUseCase, ActualizarUsuarioUseCase actualizarUsuarioUseCase, EliminarUsuarioUseCase eliminarUsuarioUseCase, ListaUsuariosUseCase listaUsuariosUseCase, ObtenerUsuarioUseCase obtenerUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
        this.actualizarUsuarioUseCase = actualizarUsuarioUseCase;
        this.eliminarUsuarioUseCase = eliminarUsuarioUseCase;
        this.listaUsuariosUseCase = listaUsuariosUseCase;
        this.obtenerUsuarioUseCase = obtenerUsuarioUseCase;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return crearUsuarioUseCase.crear(usuario);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        return actualizarUsuarioUseCase.actualizar(id, usuario);
    }

    @Override
    public Usuario actualizar(String nombre, Usuario usuario) {
        return actualizarUsuarioUseCase.actualizar(nombre, usuario);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarUsuarioUseCase.eliminar(id);
    }

    @Override
    public Usuario obtenerUsuario(Integer id) {
        return obtenerUsuarioUseCase.obtenerUsuario(id);
    }

    @Override
    public Usuario obtenerPorNombre(String nombre) {
        return obtenerUsuarioUseCase.obtenerPorNombre(nombre);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return listaUsuariosUseCase.obtenerTodos();
    }
}

