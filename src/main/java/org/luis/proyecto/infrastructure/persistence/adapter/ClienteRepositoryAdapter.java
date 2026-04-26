package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.repository.ClienteRepository;
import org.luis.proyecto.infrastructure.persistence.repository.JpaClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteRepositoryAdapter implements ClienteRepository {
    private final JpaClienteRepository jpaClienteRepository;

    public ClienteRepositoryAdapter(JpaClienteRepository jpaClienteRepository) {
        this.jpaClienteRepository = jpaClienteRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return null;
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Cliente> findAll() {
        return List.of();
    }
}
