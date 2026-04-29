package org.luis.proyecto.application.usecase.comprobantepago.impl;

import org.luis.proyecto.application.usecase.comprobantepago.ObtenerComprobantePagoUseCase;
import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.domain.repository.ComprobantePagoRepository;

public class ObtenerComprobantePagoUseCaseImpl implements ObtenerComprobantePagoUseCase {
    private final ComprobantePagoRepository comprobantePagoRepository;

    public ObtenerComprobantePagoUseCaseImpl(ComprobantePagoRepository comprobantePagoRepository) {
        this.comprobantePagoRepository = comprobantePagoRepository;
    }

    @Override
    public ComprobantePago obtenerComprobantePago(Integer id) {
        return comprobantePagoRepository.findById(id).orElseThrow();
    }
}
