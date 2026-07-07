package org.luis.proyecto.application.usecase.laboratorio.impl;

import org.luis.proyecto.application.usecase.laboratorio.ObtenerLaboratorioUseCase;
import org.luis.proyecto.domain.model.Laboratorio;
import org.luis.proyecto.domain.repository.LaboratorioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObtenerLaboratorioUseCaseImpl implements ObtenerLaboratorioUseCase {
    private final LaboratorioRepository laboratorioRepository;

    public ObtenerLaboratorioUseCaseImpl(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @Override
    public Optional<Laboratorio> obtenerPorId(Integer id) {
        return laboratorioRepository.findById(id);
    }
}
