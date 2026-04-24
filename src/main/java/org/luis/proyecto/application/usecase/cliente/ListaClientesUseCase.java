package org.luis.proyecto.application.usecase.cliente;

import org.luis.proyecto.domain.model.Cliente;

import java.util.List;

public interface ListaClientesUseCase {
    List<Cliente> obtenerTodos();
}
