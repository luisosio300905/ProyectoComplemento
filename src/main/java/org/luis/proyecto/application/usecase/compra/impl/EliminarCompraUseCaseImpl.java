package org.luis.proyecto.application.usecase.compra.impl;

import org.luis.proyecto.application.usecase.compra.EliminarCompraUseCase;
import org.luis.proyecto.domain.repository.CompraRepository;

public class EliminarCompraUseCaseImpl implements EliminarCompraUseCase {
    private final CompraRepository compraRepository;

    public EliminarCompraUseCaseImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public void eliminar(Integer id) {
        compraRepository.deleteById(id);
    }
}

