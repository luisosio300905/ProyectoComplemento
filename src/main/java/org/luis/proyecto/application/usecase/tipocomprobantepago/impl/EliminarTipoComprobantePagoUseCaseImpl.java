package org.luis.proyecto.application.usecase.tipocomprobantepago.impl;

import org.luis.proyecto.application.usecase.tipocomprobantepago.EliminarTipoComprobantePagoUseCase;
import org.luis.proyecto.domain.repository.TipoComprobantePagoRepository;

public class EliminarTipoComprobantePagoUseCaseImpl implements EliminarTipoComprobantePagoUseCase {
    private final TipoComprobantePagoRepository tipoComprobantePagoRepository;

    public EliminarTipoComprobantePagoUseCaseImpl(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        this.tipoComprobantePagoRepository = tipoComprobantePagoRepository;
    }

    @Override
    public void eliminar(Integer id) {
        tipoComprobantePagoRepository.deleteById(id);
    }
}