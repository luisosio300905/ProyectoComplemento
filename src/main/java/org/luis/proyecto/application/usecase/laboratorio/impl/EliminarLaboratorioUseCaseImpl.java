package org.luis.proyecto.application.usecase.laboratorio.impl;

import org.luis.proyecto.application.usecase.laboratorio.EliminarLaboratorioUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.repository.LaboratorioRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarLaboratorioUseCaseImpl implements EliminarLaboratorioUseCase {
    private final LaboratorioRepository laboratorioRepository;

    public EliminarLaboratorioUseCaseImpl(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @Override
    public void eliminar(Integer id) {
        if (laboratorioRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Laboratorio no encontrado con id " + id);
        }
        laboratorioRepository.deleteById(id);
    }
}
