package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Moneda;
import org.luis.proyecto.domain.repository.MonedaRepository;
import org.luis.proyecto.infrastructure.mapper.MonedaMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaMonedaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MonedaRepositoryAdapter implements MonedaRepository {
    private final JpaMonedaRepository jpaMonedaRepository;
    private final MonedaMapper monedaMapper;

    public MonedaRepositoryAdapter(JpaMonedaRepository jpaMonedaRepository, MonedaMapper monedaMapper) {
        this.jpaMonedaRepository = jpaMonedaRepository;
        this.monedaMapper = monedaMapper;
    }

    @Override
    public Moneda save(Moneda moneda) {
        return monedaMapper.toDomain(jpaMonedaRepository.save(monedaMapper.toEntity(moneda)));
    }

    @Override
    public Optional<Moneda> findById(Integer id) {
        return jpaMonedaRepository.findById(id).map(monedaMapper::toDomain);
    }

    @Override
    public void deleteById(Integer id) {
        jpaMonedaRepository.deleteById(id);
    }

    @Override
    public List<Moneda> findAll() {
        return jpaMonedaRepository.findAll().stream().map(monedaMapper::toDomain).collect(Collectors.toList());
    }
}
