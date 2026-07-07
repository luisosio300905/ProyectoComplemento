package org.luis.proyecto.application.usecase.laboratorio.impl;

import org.luis.proyecto.application.usecase.laboratorio.CrearLaboratorioUseCase;
import org.luis.proyecto.domain.model.Laboratorio;
import org.luis.proyecto.domain.repository.LaboratorioRepository;
import org.springframework.stereotype.Service;

@Service
public class CrearLaboratorioUseCaseImpl implements CrearLaboratorioUseCase {
    private final LaboratorioRepository laboratorioRepository;

    public CrearLaboratorioUseCaseImpl(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @Override
    public Laboratorio crear(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }
}
