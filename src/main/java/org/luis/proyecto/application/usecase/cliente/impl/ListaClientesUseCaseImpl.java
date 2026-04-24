package org.luis.proyecto.application.usecase.cliente.impl;

import org.luis.proyecto.application.usecase.cliente.ListaClientesUseCase;
import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.repository.ClienteRepository;

import java.util.List;

public class ListaClientesUseCaseImpl implements ListaClientesUseCase {
    private ClienteRepository clienteRepository;

    public ListaClientesUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }
}
