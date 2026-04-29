package org.luis.proyecto.application.usecase.comprobantepago.impl;

import org.luis.proyecto.application.usecase.comprobantepago.ListaComprobantePagoUseCase;
import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.domain.repository.ComprobantePagoRepository;

import java.util.List;

public class ListaComprobantePagoUseCaseImpl implements ListaComprobantePagoUseCase {
    private ComprobantePagoRepository comprobantePagoRepository;

    public ListaComprobantePagoUseCaseImpl(ComprobantePagoRepository comprobantePagoRepository) {
        this.comprobantePagoRepository = comprobantePagoRepository;
    }

    @Override
    public List<ComprobantePago> obtenerTodos(){
        return comprobantePagoRepository.findAll();
    }

}
