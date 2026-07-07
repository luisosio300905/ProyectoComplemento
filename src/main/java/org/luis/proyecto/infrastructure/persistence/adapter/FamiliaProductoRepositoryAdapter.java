package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.FamiliaProducto;
import org.luis.proyecto.domain.repository.FamiliaProductoRepository;
import org.luis.proyecto.infrastructure.mapper.FamiliaProductoMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaFamiliaProductoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FamiliaProductoRepositoryAdapter implements FamiliaProductoRepository {
    private final JpaFamiliaProductoRepository jpaFamiliaProductoRepository;
    private final FamiliaProductoMapper familiaProductoMapper;

    public FamiliaProductoRepositoryAdapter(JpaFamiliaProductoRepository jpaFamiliaProductoRepository, FamiliaProductoMapper familiaProductoMapper) {
        this.jpaFamiliaProductoRepository = jpaFamiliaProductoRepository;
        this.familiaProductoMapper = familiaProductoMapper;
    }

    @Override
    public FamiliaProducto save(FamiliaProducto familiaProducto) {
        return familiaProductoMapper.toDomain(jpaFamiliaProductoRepository.save(familiaProductoMapper.toEntity(familiaProducto)));
    }

    @Override
    public Optional<FamiliaProducto> findById(Integer id) {
        return jpaFamiliaProductoRepository.findById(id).map(familiaProductoMapper::toDomain);
    }

    @Override
    public void deleteById(Integer id) {
        jpaFamiliaProductoRepository.deleteById(id);
    }

    @Override
    public List<FamiliaProducto> findAll() {
        return jpaFamiliaProductoRepository.findAll().stream().map(familiaProductoMapper::toDomain).collect(Collectors.toList());
    }
}
