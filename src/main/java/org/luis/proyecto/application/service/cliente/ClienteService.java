package org.luis.proyecto.application.service.cliente;

import org.luis.proyecto.domain.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente crear(Cliente cliente);
    Cliente actualizar(Integer id, Cliente cliente);
    void eliminar(Integer id);
    Cliente obtenerCliente(Integer id);
    List<Cliente> obtenerTodos();
}
