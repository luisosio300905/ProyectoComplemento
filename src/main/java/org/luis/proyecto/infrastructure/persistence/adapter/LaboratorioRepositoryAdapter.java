package org.luis.proyecto.infrastructure.persistence.adapter;

import org.luis.proyecto.domain.model.Laboratorio;
import org.luis.proyecto.domain.repository.LaboratorioRepository;
import org.luis.proyecto.infrastructure.mapper.LaboratorioMapper;
import org.luis.proyecto.infrastructure.persistence.repository.JpaLaboratorioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LaboratorioRepositoryAdapter implements LaboratorioRepository {
    private final JpaLaboratorioRepository jpaLaboratorioRepository;
    private final LaboratorioMapper laboratorioMapper;

    public LaboratorioRepositoryAdapter(JpaLaboratorioRepository jpaLaboratorioRepository, LaboratorioMapper laboratorioMapper) {
        this.jpaLaboratorioRepository = jpaLaboratorioRepository;
        this.laboratorioMapper = laboratorioMapper;
    }

    @Override
    public Laboratorio save(Laboratorio laboratorio) {
        return laboratorioMapper.toDomain(jpaLaboratorioRepository.save(laboratorioMapper.toEntity(laboratorio)));
    }

    @Override
    public Optional<Laboratorio> findById(Integer id) {
        return jpaLaboratorioRepository.findById(id).map(laboratorioMapper::toDomain);
    }

    @Override
    public void deleteById(Integer id) {
        jpaLaboratorioRepository.deleteById(id);
    }

    @Override
    public List<Laboratorio> findAll() {
        return jpaLaboratorioRepository.findAll().stream().map(laboratorioMapper::toDomain).collect(Collectors.toList());
    }
}
