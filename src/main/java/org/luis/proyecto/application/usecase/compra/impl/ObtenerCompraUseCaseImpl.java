package org.luis.proyecto.application.usecase.compra.impl;

import org.luis.proyecto.application.usecase.compra.ObtenerCompraUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Compra;
import org.luis.proyecto.domain.repository.CompraRepository;

public class ObtenerCompraUseCaseImpl implements ObtenerCompraUseCase {
    private final CompraRepository compraRepository;

    public ObtenerCompraUseCaseImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra obtenerCompra(Integer id) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compra no encontrada"));
    }
}

