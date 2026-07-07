package org.luis.proyecto.application.service.subdivisionaria.impl;

import org.luis.proyecto.application.service.subdivisionaria.SubDivisionariaService;
import org.luis.proyecto.domain.model.SubDivisionaria;
import org.luis.proyecto.domain.repository.SubDivisionariaRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.infrastructure.persistence.entity.SubDivisionariaPK;

import java.util.List;

public class SubDivisionariaServiceImpl implements SubDivisionariaService {
    private final SubDivisionariaRepository subDivisionariaRepository;

    public SubDivisionariaServiceImpl(SubDivisionariaRepository subDivisionariaRepository) {
        this.subDivisionariaRepository = subDivisionariaRepository;
    }

    @Override
    public SubDivisionaria crear(SubDivisionaria subDivisionaria) {
        return subDivisionariaRepository.save(subDivisionaria);
    }

    @Override
    public SubDivisionaria actualizar(SubDivisionariaPK id, SubDivisionaria subDivisionaria) {
        subDivisionariaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubDivisionaria no encontrada"));
        return subDivisionariaRepository.save(subDivisionaria);
    }

    @Override
    public void eliminar(SubDivisionariaPK id) {
        subDivisionariaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubDivisionaria no encontrada"));
        subDivisionariaRepository.deleteById(id);
    }

    @Override
    public SubDivisionaria obtenerById(SubDivisionariaPK id) {
        return subDivisionariaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubDivisionaria no encontrada"));
    }

    @Override
    public List<SubDivisionaria> obtenerTodos() {
        return subDivisionariaRepository.findAll();
    }

    @Override
    public List<SubDivisionaria> obtenerPorDivisionaria(String cuentaId, String subCtaId, String divisioId) {
        return subDivisionariaRepository.findByDivisionariaId(cuentaId, subCtaId, divisioId);
    }

    @Override
    public void eliminarPorDivisionaria(String cuentaId, String subCtaId, String divisioId) {
        subDivisionariaRepository.deleteByDivisionariaId(cuentaId, subCtaId, divisioId);
    }
}

