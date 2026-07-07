package org.luis.proyecto.application.service.divisionaria.impl;

import org.luis.proyecto.application.service.divisionaria.DivisionariaService;
import org.luis.proyecto.domain.model.Divisionaria;
import org.luis.proyecto.domain.repository.DivisionariaRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.infrastructure.persistence.entity.DivisionariaPK;

import java.util.List;

public class DivisionariaServiceImpl implements DivisionariaService {
    private final DivisionariaRepository divisionariaRepository;

    public DivisionariaServiceImpl(DivisionariaRepository divisionariaRepository) {
        this.divisionariaRepository = divisionariaRepository;
    }

    @Override
    public Divisionaria crear(Divisionaria divisionaria) {
        return divisionariaRepository.save(divisionaria);
    }

    @Override
    public Divisionaria actualizar(DivisionariaPK id, Divisionaria divisionaria) {
        divisionariaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Divisionaria no encontrada"));
        return divisionariaRepository.save(divisionaria);
    }

    @Override
    public void eliminar(DivisionariaPK id) {
        divisionariaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Divisionaria no encontrada"));
        divisionariaRepository.deleteById(id);
    }

    @Override
    public Divisionaria obtenerById(DivisionariaPK id) {
        return divisionariaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Divisionaria no encontrada"));
    }

    @Override
    public List<Divisionaria> obtenerTodos() {
        return divisionariaRepository.findAll();
    }

    @Override
    public List<Divisionaria> obtenerPorSubCuenta(String cuentaId, String subCtaId) {
        return divisionariaRepository.findBySubCuentaId(cuentaId, subCtaId);
    }

    @Override
    public void eliminarPorSubCuenta(String cuentaId, String subCtaId) {
        divisionariaRepository.deleteBySubCuentaId(cuentaId, subCtaId);
    }
}

