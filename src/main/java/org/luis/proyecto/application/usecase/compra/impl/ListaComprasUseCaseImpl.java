package org.luis.proyecto.application.usecase.compra.impl;

import org.luis.proyecto.application.usecase.compra.ListaComprasUseCase;
import org.luis.proyecto.domain.model.Compra;
import org.luis.proyecto.domain.repository.CompraRepository;

import java.util.List;

public class ListaComprasUseCaseImpl implements ListaComprasUseCase {
    private final CompraRepository compraRepository;

    public ListaComprasUseCaseImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public List<Compra> obtenerTodas() {
        return compraRepository.findAll();
    }
}

