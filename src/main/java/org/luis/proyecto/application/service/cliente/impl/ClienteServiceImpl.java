package org.luis.proyecto.application.service.cliente.impl;

import org.luis.proyecto.application.usecase.cliente.*;
import org.luis.proyecto.application.service.cliente.ClienteService;
import org.luis.proyecto.domain.model.Cliente;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private final CrearClienteUseCase crearClienteUseCase;
    private final ActualizarClienteUseCase actualizarClienteUseCase;
    private final EliminarClienteUseCase eliminarClienteUseCase;
    private final ListaClientesUseCase listaClientesUseCase;
    private final ObtenerClienteUseCase obtenerClienteUseCase;

    public ClienteServiceImpl(CrearClienteUseCase crearClienteUseCase, ActualizarClienteUseCase actualizarClienteUseCase, EliminarClienteUseCase eliminarClienteUseCase, ListaClientesUseCase listaClientesUseCase, ObtenerClienteUseCase obtenerClienteUseCase) {
        this.crearClienteUseCase = crearClienteUseCase;
        this.actualizarClienteUseCase = actualizarClienteUseCase;
        this.eliminarClienteUseCase = eliminarClienteUseCase;
        this.listaClientesUseCase = listaClientesUseCase;
        this.obtenerClienteUseCase = obtenerClienteUseCase;
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return crearClienteUseCase.crear(cliente);
    }

    @Override
    public Cliente actualizar(Integer id, Cliente cliente) {
        return actualizarClienteUseCase.actualizar(id, cliente);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarClienteUseCase.eliminar(id);
    }

    @Override
    public Cliente obtenerCliente(Integer id) {
        return obtenerClienteUseCase.obtenerCliente(id);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return listaClientesUseCase.obtenerTodos();
    }
}

