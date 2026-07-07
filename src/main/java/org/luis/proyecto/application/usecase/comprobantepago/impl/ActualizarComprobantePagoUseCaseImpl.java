package org.luis.proyecto.application.usecase.comprobantepago.impl;

import org.luis.proyecto.application.usecase.comprobantepago.ActualizarComprobantePagoUseCase;
import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.domain.repository.ComprobantePagoRepository;

public class ActualizarComprobantePagoUseCaseImpl implements ActualizarComprobantePagoUseCase {
    private final ComprobantePagoRepository comprobantePagoRepository;

    public ActualizarComprobantePagoUseCaseImpl(ComprobantePagoRepository comprobantePagoRepository) {
        this.comprobantePagoRepository = comprobantePagoRepository;
    }

    @Override
    public ComprobantePago actualizar(String id, ComprobantePago comprobantePago) {
        ComprobantePago comprobantePagoActualizar = comprobantePagoRepository.findById(id).orElseThrow();
        actualizarComprobantePago(comprobantePagoActualizar, comprobantePago);
        return comprobantePagoRepository.save(comprobantePagoActualizar);
    }

    private void actualizarComprobantePago(ComprobantePago actualizar, ComprobantePago datos){
        actualizar.setComPagDescripcion(datos.getComPagDescripcion());
        actualizar.setUsrSistema(datos.getUsrSistema());
        actualizar.setFecSistema(datos.getFecSistema());
        actualizar.setHrsSistema(datos.getHrsSistema());
    }
}
