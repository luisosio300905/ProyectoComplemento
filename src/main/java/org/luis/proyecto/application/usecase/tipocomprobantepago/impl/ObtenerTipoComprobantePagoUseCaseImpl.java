package org.luis.proyecto.application.usecase.tipocomprobantepago.impl;

import org.luis.proyecto.application.usecase.tipocomprobantepago.ObtenerTipoComprobantePagoUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.TipoComprobantePago;
import org.luis.proyecto.domain.repository.TipoComprobantePagoRepository;

public class ObtenerTipoComprobantePagoUseCaseImpl implements ObtenerTipoComprobantePagoUseCase {
    private final TipoComprobantePagoRepository tipoComprobantePagoRepository;

    public ObtenerTipoComprobantePagoUseCaseImpl(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        this.tipoComprobantePagoRepository = tipoComprobantePagoRepository;
    }

    @Override
    public TipoComprobantePago obtener(Integer id) {
        return tipoComprobantePagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de comprobante de pago no encontrado"));
    }
}