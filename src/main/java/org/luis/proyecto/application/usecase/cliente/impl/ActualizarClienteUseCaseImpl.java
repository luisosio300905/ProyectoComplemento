package org.luis.proyecto.application.usecase.cliente.impl;

import org.luis.proyecto.application.usecase.cliente.ActualizarClienteUseCase;
import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.repository.ClienteRepository;

public class ActualizarClienteUseCaseImpl implements ActualizarClienteUseCase {
    private final ClienteRepository clienteRepository;

    public ActualizarClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente actualizar(Integer id, Cliente cliente) {
        Cliente clienteActualizar = clienteRepository.findById(id).orElseThrow();
        clienteActualizar.setNombres(cliente.getNombres());
        clienteActualizar.setRazonSocial(cliente.getRazonSocial());
        clienteActualizar.setDescripcion(cliente.getDescripcion());
        clienteActualizar.setApellidoPaterno(cliente.getApellidoPaterno());
        clienteActualizar.setApellidoMaterno(cliente.getApellidoMaterno());
        clienteActualizar.setCelular(cliente.getCelular());
        clienteActualizar.setComprobantes(cliente.getComprobantes());
        clienteActualizar.setCorreo(cliente.getCorreo());
        clienteActualizar.setDireccion(cliente.getDireccion());
        clienteActualizar.setNumeroDocumento(cliente.getNumeroDocumento());
        clienteActualizar.setTipoDocumentoIdentidad(cliente.getTipoDocumentoIdentidad());
        return clienteRepository.save(clienteActualizar);
    }
}
