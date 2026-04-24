package org.luis.proyecto.application.usecase.cliente;


import org.luis.proyecto.domain.model.Cliente;

public interface ActualizarClienteUseCase {
    Cliente actualizar(Integer id, Cliente cliente);
}
