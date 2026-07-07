package org.luis.proyecto.application.usecase.diariocabecera.impl;

import org.luis.proyecto.application.usecase.diariocabecera.ActualizarDiarioCabeceraUseCase;
import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;

public class ActualizarDiarioCabeceraUseCaseImpl implements ActualizarDiarioCabeceraUseCase {
    private final DiarioCabeceraRepository diarioCabeceraRepository;

    public ActualizarDiarioCabeceraUseCaseImpl(DiarioCabeceraRepository diarioCabeceraRepository) {
        this.diarioCabeceraRepository = diarioCabeceraRepository;
    }

    @Override
    public DiarioCabecera actualizar(Long id, DiarioCabecera diarioCabecera) {
        DiarioCabecera existente = diarioCabeceraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DiarioCabecera no encontrada con ID: " + id));

        diarioCabecera.setDiaCabCompId(existente.getDiaCabCompId());
        return diarioCabeceraRepository.save(diarioCabecera);
    }
}

