package org.luis.proyecto.application.usecase.laboratorio.impl;

import org.luis.proyecto.application.usecase.laboratorio.ListarLaboratoriosUseCase;
import org.luis.proyecto.domain.model.Laboratorio;
import org.luis.proyecto.domain.repository.LaboratorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarLaboratoriosUseCaseImpl implements ListarLaboratoriosUseCase {
    private final LaboratorioRepository laboratorioRepository;

    public ListarLaboratoriosUseCaseImpl(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @Override
    public List<Laboratorio> listar() {
        return laboratorioRepository.findAll();
    }
}
