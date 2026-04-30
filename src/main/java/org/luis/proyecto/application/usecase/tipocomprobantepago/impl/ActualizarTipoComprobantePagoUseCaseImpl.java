package org.luis.proyecto.application.usecase.tipocomprobantepago.impl;

import org.luis.proyecto.application.usecase.tipocomprobantepago.ActualizarTipoComprobantePagoUseCase;
import org.luis.proyecto.domain.model.TipoComprobantePago;
import org.luis.proyecto.domain.repository.TipoComprobantePagoRepository;

public class ActualizarTipoComprobantePagoUseCaseImpl implements ActualizarTipoComprobantePagoUseCase {
    private final TipoComprobantePagoRepository tipoComprobantePagoRepository;

    public ActualizarTipoComprobantePagoUseCaseImpl(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        this.tipoComprobantePagoRepository = tipoComprobantePagoRepository;
    }

    @Override
    public TipoComprobantePago actualizar(Integer id, TipoComprobantePago tipoComprobantePago) {
        TipoComprobantePago tipoActualizar = tipoComprobantePagoRepository.findById(id).orElseThrow();
        actualizarTipoComprobantePago(tipoActualizar, tipoComprobantePago);
        return tipoComprobantePagoRepository.save(tipoActualizar);
    }

    private void actualizarTipoComprobantePago(TipoComprobantePago tipo1, TipoComprobantePago tipo2) {
        tipo1.setTipoComprobante(tipo2.getTipoComprobante());
    }
}