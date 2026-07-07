package org.luis.proyecto.application.usecase.diariocabecera.impl;

import org.luis.proyecto.application.usecase.diariocabecera.ObtenerDiarioCabeceraUseCase;
import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;

import java.util.List;

public class ObtenerDiarioCabeceraUseCaseImpl implements ObtenerDiarioCabeceraUseCase {
    private final DiarioCabeceraRepository diarioCabeceraRepository;

    public ObtenerDiarioCabeceraUseCaseImpl(DiarioCabeceraRepository diarioCabeceraRepository) {
        this.diarioCabeceraRepository = diarioCabeceraRepository;
    }

    @Override
    public DiarioCabecera obtenerById(Long id) {
        return diarioCabeceraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DiarioCabecera no encontrada con ID: " + id));
    }

    @Override
    public DiarioCabecera obtenerByEmpresaId(String empresaId) {
        List<DiarioCabecera> result = diarioCabeceraRepository.findByEmpresaId(empresaId);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("DiarioCabecera no encontrada con EmpresaId: " + empresaId);
        }
        return result.get(0);
    }
}

