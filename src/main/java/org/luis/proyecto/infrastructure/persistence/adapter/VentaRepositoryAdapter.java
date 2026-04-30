package org.luis.proyecto.infrastructure.persistence.adapter;

import java.util.List;

import org.luis.proyecto.domain.model.Venta;
import java.util.Optional;
import org.luis.proyecto.domain.repository.VentaRepository;
import org.luis.proyecto.infrastructure.mapper.VentaMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaVentaRepository;
import org.springframework.stereotype.Component;

@Component
public class VentaRepositoryAdapter implements VentaRepository{
    private final JpaVentaRepository jpaVentaRepository;
    private final VentaMapper ventaMapper;

    public VentaRepositoryAdapter(JpaVentaRepository jpaVentaRepository, VentaMapper ventaMapper) {
        this.jpaVentaRepository = jpaVentaRepository;
        this.ventaMapper = ventaMapper;
    }

    @Override
    public Venta save(Venta venta) {
        return ventaMapper
                .toVenta(jpaVentaRepository.save(ventaMapper.toVentaEntity(venta)));
    }

    @Override
    public Optional<Venta> findById(Integer id) {
        return jpaVentaRepository
                .findById(id).map(p -> ventaMapper.toVenta(p));
    }


    @Override
    public void deleteById(Integer id) {
        jpaVentaRepository.deleteById(id);
    }

    @Override
    public List<Venta> findAll() {
        return ventaMapper.toVentaList(jpaVentaRepository.findAll());
    }
}
