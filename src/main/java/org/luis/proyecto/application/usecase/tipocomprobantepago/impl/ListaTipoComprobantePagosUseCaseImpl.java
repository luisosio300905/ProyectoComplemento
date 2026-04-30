package org.luis.proyecto.application.usecase.tipocomprobantepago.impl;

import org.luis.proyecto.application.usecase.tipocomprobantepago.ListaTipoComprobantePagosUseCase;
import org.luis.proyecto.domain.model.TipoComprobantePago;
import org.luis.proyecto.domain.repository.TipoComprobantePagoRepository;

import java.util.List;

public class ListaTipoComprobantePagosUseCaseImpl implements ListaTipoComprobantePagosUseCase {
    private final TipoComprobantePagoRepository tipoComprobantePagoRepository;

    public ListaTipoComprobantePagosUseCaseImpl(TipoComprobantePagoRepository tipoComprobantePagoRepository) {
        this.tipoComprobantePagoRepository = tipoComprobantePagoRepository;
    }

    @Override
    public List<TipoComprobantePago> listar() {
        return tipoComprobantePagoRepository.findAll();
    }
}