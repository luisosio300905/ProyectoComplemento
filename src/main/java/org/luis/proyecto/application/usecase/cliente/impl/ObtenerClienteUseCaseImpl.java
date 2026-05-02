package org.luis.proyecto.application.usecase.cliente.impl;

import org.luis.proyecto.application.usecase.cliente.ObtenerClienteUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.repository.ClienteRepository;
import org.springframework.http.HttpStatus;

public class ObtenerClienteUseCaseImpl implements ObtenerClienteUseCase {
    private final ClienteRepository clienteRepository;

    public ObtenerClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente obtenerCliente(Integer id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cliente no encontrado"));
    }
}
