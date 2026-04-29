package org.luis.proyecto.application.service.cliente;

import org.luis.proyecto.infrastructure.rest.request.ClienteRequest;
import org.luis.proyecto.infrastructure.rest.response.ClienteResponse;

import java.util.List;

public interface ClienteService {
    ClienteResponse crear(ClienteRequest cliente);

    ClienteResponse actualizar(Integer id, ClienteRequest cliente);

    void eliminar(Integer id);

    ClienteResponse obtenerCliente(Integer id);

    List<ClienteResponse> obtenerTodos();
}
