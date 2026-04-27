package org.luis.proyecto.application.usecase.comprobantepago.impl;

import org.luis.proyecto.application.usecase.comprobantepago.CrearComprobantePagoUseCase;
import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.domain.repository.ComprobantePagoRepository;

public class CrearComprobantePagoUseCaseImpl implements CrearComprobantePagoUseCase {
    private final ComprobantePagoRepository comprobantePagoRepository;

    public CrearComprobantePagoUseCaseImpl(ComprobantePagoRepository comprobantePagoRepository) {
        this.comprobantePagoRepository = comprobantePagoRepository;
    }


    @Override
    public ComprobantePago crear(ComprobantePago comprobantePago) {
        return comprobantePagoRepository.save(comprobantePago);
    }
}
