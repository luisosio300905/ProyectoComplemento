package org.luis.proyecto.application.usecase.compra.impl;

import org.luis.proyecto.application.usecase.compra.CrearCompraUseCase;
import org.luis.proyecto.domain.model.Compra;
import org.luis.proyecto.domain.repository.CompraRepository;

public class CrearCompraUseCaseImpl implements CrearCompraUseCase {
    private final CompraRepository compraRepository;

    public CrearCompraUseCaseImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra crear(Compra compra) {
        return compraRepository.save(compra);
    }
}

