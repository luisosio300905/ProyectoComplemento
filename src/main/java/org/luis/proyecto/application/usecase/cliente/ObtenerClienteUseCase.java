package org.luis.proyecto.application.usecase.cliente;

import org.luis.proyecto.domain.model.Cliente;

public interface ObtenerClienteUseCase {
    Cliente obtenerCliente(Integer id);
}
