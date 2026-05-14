package org.luis.proyecto.application.usecase.compra.impl;

import org.luis.proyecto.application.usecase.compra.ActualizarCompraUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Compra;
import org.luis.proyecto.domain.repository.CompraRepository;

public class ActualizarCompraUseCaseImpl implements ActualizarCompraUseCase {
    private final CompraRepository compraRepository;

    public ActualizarCompraUseCaseImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra actualizar(Integer id, Compra compra) {
        compraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compra no encontrada"));
        compra.setId(id);
        return compraRepository.save(compra);
    }
}

