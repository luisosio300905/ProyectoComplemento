package org.luis.proyecto.application.usecase.laboratorio.impl;

import org.luis.proyecto.application.usecase.laboratorio.ActualizarLaboratorioUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Laboratorio;
import org.luis.proyecto.domain.repository.LaboratorioRepository;
import org.springframework.stereotype.Service;

@Service
public class ActualizarLaboratorioUseCaseImpl implements ActualizarLaboratorioUseCase {
    private final LaboratorioRepository laboratorioRepository;

    public ActualizarLaboratorioUseCaseImpl(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @Override
    public Laboratorio actualizar(Integer id, Laboratorio laboratorio) {
        Laboratorio existente = laboratorioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laboratorio no encontrado con id " + id));
        existente.setLabDescripcion(laboratorio.getLabDescripcion());
        existente.setLabEstado(laboratorio.getLabEstado());
        existente.setCodlab(laboratorio.getCodlab());
        existente.setUsrSistema(laboratorio.getUsrSistema());
        existente.setFecSistema(laboratorio.getFecSistema());
        existente.setHrsSistema(laboratorio.getHrsSistema());

        return laboratorioRepository.save(existente);
    }
}
