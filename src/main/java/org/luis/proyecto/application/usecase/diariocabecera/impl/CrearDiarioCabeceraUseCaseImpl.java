package org.luis.proyecto.application.usecase.diariocabecera.impl;

import org.luis.proyecto.application.usecase.diariocabecera.CrearDiarioCabeceraUseCase;
import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;

public class CrearDiarioCabeceraUseCaseImpl implements CrearDiarioCabeceraUseCase {
    private final DiarioCabeceraRepository diarioCabeceraRepository;

    public CrearDiarioCabeceraUseCaseImpl(DiarioCabeceraRepository diarioCabeceraRepository) {
        this.diarioCabeceraRepository = diarioCabeceraRepository;
    }

    @Override
    public DiarioCabecera crear(DiarioCabecera diarioCabecera) {
        return diarioCabeceraRepository.save(diarioCabecera);
    }
}

