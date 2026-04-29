package org.luis.proyecto.application.service.cliente.impl;

import org.luis.proyecto.application.service.cliente.ClienteService;
import org.luis.proyecto.application.usecase.cliente.*;
import org.luis.proyecto.infrastructure.mapper.ClienteMapper;
import org.luis.proyecto.infrastructure.rest.request.ClienteRequest;
import org.luis.proyecto.infrastructure.rest.response.ClienteResponse;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private final CrearClienteUseCase crearClienteUseCase;
    private final ActualizarClienteUseCase actualizarClienteUseCase;
    private final EliminarClienteUseCase eliminarClienteUseCase;
    private final ListaClientesUseCase listaClientesUseCase;
    private final ObtenerClienteUseCase obtenerClienteUseCase;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(
            CrearClienteUseCase crearClienteUseCase,
            ActualizarClienteUseCase actualizarClienteUseCase,
            EliminarClienteUseCase eliminarClienteUseCase,
            ListaClientesUseCase listaClientesUseCase,
            ObtenerClienteUseCase obtenerClienteUseCase,
            ClienteMapper clienteMapper
    ) {
        this.crearClienteUseCase = crearClienteUseCase;
        this.actualizarClienteUseCase = actualizarClienteUseCase;
        this.eliminarClienteUseCase = eliminarClienteUseCase;
        this.listaClientesUseCase = listaClientesUseCase;
        this.obtenerClienteUseCase = obtenerClienteUseCase;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteResponse crear(ClienteRequest cliente) {
        return clienteMapper.toClienteResponse(
                crearClienteUseCase.crear(clienteMapper.toCliente(cliente))
        );
    }

    @Override
    public ClienteResponse actualizar(Integer id, ClienteRequest cliente) {
        return clienteMapper.toClienteResponse(
                actualizarClienteUseCase.actualizar(id, clienteMapper.toCliente(cliente))
        );
    }

    @Override
    public void eliminar(Integer id) {
        eliminarClienteUseCase.eliminar(id);
    }

    @Override
    public ClienteResponse obtenerCliente(Integer id) {
        return clienteMapper.toClienteResponse(
                obtenerClienteUseCase.obtenerCliente(id)
        );
    }

    @Override
    public List<ClienteResponse> obtenerTodos() {
        return clienteMapper.toClienteResponseList(
                listaClientesUseCase.obtenerTodos()
        );
    }
}
