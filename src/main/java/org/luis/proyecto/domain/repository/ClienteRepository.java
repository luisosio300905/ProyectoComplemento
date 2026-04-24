package org.luis.proyecto.domain.repository;


import org.luis.proyecto.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Integer id);
    void deleteById(Integer id);
    List<Cliente> findAll();
}
