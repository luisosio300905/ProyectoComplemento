package org.luis.proyecto.application.usecase.diariocabecera.impl;

import org.luis.proyecto.application.usecase.diariocabecera.EliminarDiarioCabeceraUseCase;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;

public class EliminarDiarioCabeceraUseCaseImpl implements EliminarDiarioCabeceraUseCase {
    private final DiarioCabeceraRepository diarioCabeceraRepository;

    public EliminarDiarioCabeceraUseCaseImpl(DiarioCabeceraRepository diarioCabeceraRepository) {
        this.diarioCabeceraRepository = diarioCabeceraRepository;
    }

    @Override
    public void eliminar(Long id) {
        if (!diarioCabeceraRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException("DiarioCabecera no encontrada con ID: " + id);
        }
        diarioCabeceraRepository.deleteById(id);
    }
}

