package org.luis.proyecto.application.usecase.tipocomprobantepago.impl;

import org.luis.proyecto.application.usecase.tipocomprobantepago.CrearTipoComprobantePagoUseCase;
import org.luis.proyecto.domain.model.TipoComprobantePago;
import org.luis.proyecto.domain.repository.TipoComprobantePagoRepository;

public class CrearTipoComprobantePagoUseCaseImpl implements CrearTipoComprobantePagoUseCase {
    private final TipoComprobantePagoRepository tipoComprobantePagoRepository;

    public CrearTipoComprobantePagoUseCaseImpl(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        this.tipoComprobantePagoRepository = tipoComprobantePagoRepository;
    }

    @Override
    public TipoComprobantePago crear(TipoComprobantePago tipoComprobantePago) {
        return tipoComprobantePagoRepository.save(tipoComprobantePago);
    }
}