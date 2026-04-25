package org.luis.proyecto.application.service.usuario.impl;

import org.luis.proyecto.application.usecase.usuario.*;
import org.luis.proyecto.application.service.usuario.UsuarioService;
import org.luis.proyecto.domain.model.Usuario;
import org.luis.proyecto.infrastructure.mapper.UsuarioMapper;
import org.luis.proyecto.infrastructure.rest.request.UsuarioRequest;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final ActualizarUsuarioUseCase actualizarUsuarioUseCase;
    private final EliminarUsuarioUseCase eliminarUsuarioUseCase;
    private final ListaUsuariosUseCase listaUsuariosUseCase;
    private final ObtenerUsuarioUseCase obtenerUsuarioUseCase;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(CrearUsuarioUseCase crearUsuarioUseCase, ActualizarUsuarioUseCase actualizarUsuarioUseCase, EliminarUsuarioUseCase eliminarUsuarioUseCase, ListaUsuariosUseCase listaUsuariosUseCase, ObtenerUsuarioUseCase obtenerUsuarioUseCase, UsuarioMapper usuarioMapper) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
        this.actualizarUsuarioUseCase = actualizarUsuarioUseCase;
        this.eliminarUsuarioUseCase = eliminarUsuarioUseCase;
        this.listaUsuariosUseCase = listaUsuariosUseCase;
        this.obtenerUsuarioUseCase = obtenerUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario crear(UsuarioRequest usuario) {
        return crearUsuarioUseCase.crear(usuarioMapper.toUsuario(usuario));
    }

    @Override
    public Usuario actualizar(Integer id, UsuarioRequest usuario) {
        return actualizarUsuarioUseCase.actualizar(id, usuarioMapper.toUsuario(usuario));
    }

    @Override
    public Usuario actualizar(String nombre, UsuarioRequest usuario) {
        return actualizarUsuarioUseCase.actualizar(nombre, usuarioMapper.toUsuario(usuario));
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

