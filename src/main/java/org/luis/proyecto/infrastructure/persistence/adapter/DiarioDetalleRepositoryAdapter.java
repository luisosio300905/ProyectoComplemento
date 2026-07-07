package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;
import org.luis.proyecto.infrastructure.mapper.DiarioDetalleMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaDiarioDetalleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DiarioDetalleRepositoryAdapter implements DiarioDetalleRepository {
    private final JpaDiarioDetalleRepository jpaDiarioDetalleRepository;
    private final DiarioDetalleMapper diarioDetalleMapper;

    public DiarioDetalleRepositoryAdapter(JpaDiarioDetalleRepository jpaDiarioDetalleRepository, DiarioDetalleMapper diarioDetalleMapper) {
        this.jpaDiarioDetalleRepository = jpaDiarioDetalleRepository;
        this.diarioDetalleMapper = diarioDetalleMapper;
    }

    @Override
    public DiarioDetalle save(DiarioDetalle diarioDetalle) {
        return diarioDetalleMapper
                .toDiarioDetalle(jpaDiarioDetalleRepository.save(diarioDetalleMapper.toDiarioDetalleEntity(diarioDetalle)));
    }

    @Override
    public Optional<DiarioDetalle> findById(Integer id) {
        return jpaDiarioDetalleRepository
                .findById(id).map(diarioDetalleMapper::toDiarioDetalle);
    }

    @Override
    public void deleteById(Integer id) {
        jpaDiarioDetalleRepository.deleteById(id);
    }

    @Override
    public List<DiarioDetalle> findAll() {
        return diarioDetalleMapper.toDiarioDetalleList(jpaDiarioDetalleRepository.findAll());
    }

    @Override
    public List<DiarioDetalle> findByDiaCabCompId(Long diaCabCompId) {
        return diarioDetalleMapper.toDiarioDetalleList(jpaDiarioDetalleRepository.findByDiaCabCompId(diaCabCompId));
    }

    @Override
    public void deleteByDiaCabCompId(Long diaCabCompId) {
        jpaDiarioDetalleRepository.deleteByDiaCabCompId(diaCabCompId);
    }
}

