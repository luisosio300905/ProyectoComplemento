package org.luis.proyecto.application.usecase.cliente.impl;

import org.luis.proyecto.application.usecase.cliente.CrearClienteUseCase;
import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.repository.ClienteRepository;

public class CrearClienteUseCaseImpl implements CrearClienteUseCase {
    private final ClienteRepository clienteRepository;

    public CrearClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
