package org.luis.proyecto.application.usecase.comprobantepago.impl;

import org.luis.proyecto.application.usecase.comprobantepago.EliminarComprobantePagoUseCase;
import org.luis.proyecto.domain.repository.ComprobantePagoRepository;

public class EliminarComprobantePagoUseCaseImpl implements EliminarComprobantePagoUseCase {
    private final ComprobantePagoRepository comprobantePagoRepository;

    public EliminarComprobantePagoUseCaseImpl(ComprobantePagoRepository comprobantePagoRepository) {
        this.comprobantePagoRepository = comprobantePagoRepository;
    }

    @Override
    public void eliminar(Integer id) {
        comprobantePagoRepository.deleteById(id);
    }
}
