package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.domain.repository.ClienteRepository;
import org.luis.proyecto.infrastructure.mapper.ClienteMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteRepositoryAdapter implements ClienteRepository {
    private final JpaClienteRepository jpaClienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteRepositoryAdapter(JpaClienteRepository jpaClienteRepository,
                                    ClienteMapper clienteMapper) {
        this.jpaClienteRepository = jpaClienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteMapper.toCliente(
                jpaClienteRepository.save(
                        clienteMapper.toClienteEntity(cliente)
                )
        );
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return jpaClienteRepository
                .findById(id)
                .map(clienteMapper::toCliente);
    }

    @Override
    public void deleteById(Integer id) {
        jpaClienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteMapper.toClienteList(
                jpaClienteRepository.findAll()
        );
    }
}
