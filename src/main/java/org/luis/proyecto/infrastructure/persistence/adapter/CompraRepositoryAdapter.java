package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Compra;
import org.luis.proyecto.domain.repository.CompraRepository;
import org.luis.proyecto.infrastructure.mapper.CompraMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaCompraRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompraRepositoryAdapter implements CompraRepository {
    private final JpaCompraRepository jpaCompraRepository;
    private final CompraMapper compraMapper;

    public CompraRepositoryAdapter(JpaCompraRepository jpaCompraRepository, CompraMapper compraMapper) {
        this.jpaCompraRepository = jpaCompraRepository;
        this.compraMapper = compraMapper;
    }

    @Override
    public Compra save(Compra compra) {
        return compraMapper.toCompra(
                jpaCompraRepository.save(
                        compraMapper.toCompraEntity(compra)
                )
        );
    }

    @Override
    public Optional<Compra> findById(Integer id) {
        return jpaCompraRepository
                .findById(id)
                .map(compraMapper::toCompra);
    }

    @Override
    public void deleteById(Integer id) {
        jpaCompraRepository.deleteById(id);
    }

    @Override
    public List<Compra> findAll() {
        return compraMapper.toCompraList(
                jpaCompraRepository.findAll()
        );
    }
}

