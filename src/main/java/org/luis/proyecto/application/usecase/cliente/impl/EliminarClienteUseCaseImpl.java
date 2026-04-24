package org.luis.proyecto.application.usecase.cliente.impl;

import org.luis.proyecto.application.usecase.cliente.EliminarClienteUseCase;
import org.luis.proyecto.domain.repository.ClienteRepository;

public class EliminarClienteUseCaseImpl implements EliminarClienteUseCase {
    private final ClienteRepository clienteRepository;

    public EliminarClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
