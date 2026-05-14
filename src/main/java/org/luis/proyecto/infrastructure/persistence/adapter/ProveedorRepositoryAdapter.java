package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Proveedor;
import org.luis.proyecto.domain.repository.ProveedorRepository;
import org.luis.proyecto.infrastructure.mapper.ProveedorMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaProveedorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProveedorRepositoryAdapter implements ProveedorRepository {
    private final JpaProveedorRepository jpaProveedorRepository;
    private final ProveedorMapper proveedorMapper;

    public ProveedorRepositoryAdapter(JpaProveedorRepository jpaProveedorRepository,
                                      ProveedorMapper proveedorMapper) {
        this.jpaProveedorRepository = jpaProveedorRepository;
        this.proveedorMapper = proveedorMapper;
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorMapper.toProveedor(
                jpaProveedorRepository.save(
                        proveedorMapper.toProveedorEntity(proveedor)
                )
        );
    }

    @Override
    public Optional<Proveedor> findById(Integer id) {
        return jpaProveedorRepository
                .findById(id)
                .map(proveedorMapper::toProveedor);
    }

    @Override
    public void deleteById(Integer id) {
        jpaProveedorRepository.deleteById(id);
    }

    @Override
    public List<Proveedor> findAll() {
        return proveedorMapper.toProveedorList(
                jpaProveedorRepository.findAll()
        );
    }
}

