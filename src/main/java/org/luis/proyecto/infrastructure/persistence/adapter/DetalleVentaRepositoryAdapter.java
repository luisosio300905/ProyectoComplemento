package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.DetalleVenta;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;
import org.luis.proyecto.infrastructure.mapper.DetalleVentaMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaDetalleVentaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DetalleVentaRepositoryAdapter implements DetalleVentaRepository {

    private final JpaDetalleVentaRepository jpaDetalleVentaRepository;
    private final DetalleVentaMapper detalleVentaMapper;

    public DetalleVentaRepositoryAdapter(JpaDetalleVentaRepository jpaDetalleVentaRepository, DetalleVentaMapper detalleVentaMapper) {
        this.jpaDetalleVentaRepository = jpaDetalleVentaRepository;
        this.detalleVentaMapper = detalleVentaMapper;
    }

    @Override
    public DetalleVenta save(DetalleVenta detalleVenta) {
        return detalleVentaMapper.toDetalleVenta(jpaDetalleVentaRepository.save(detalleVentaMapper.toDetalleVentaEntity(detalleVenta)));
    }

    @Override
    public void deleteById(Integer id) {
        jpaDetalleVentaRepository.deleteById(id);
    }

    @Override
    public Optional<DetalleVenta> findById(Integer id) {
        return jpaDetalleVentaRepository.findById(id).map(detalleVentaMapper::toDetalleVenta);
    }

    @Override
    public List<DetalleVenta> findAll() {
        return detalleVentaMapper.toDetalleVentaList(jpaDetalleVentaRepository.findAll());
    }
}