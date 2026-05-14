package org.luis.proyecto.application.usecase.proveedor.impl;

import org.luis.proyecto.application.usecase.proveedor.ListaProveedoresUseCase;
import org.luis.proyecto.domain.model.Proveedor;
import org.luis.proyecto.domain.repository.ProveedorRepository;

import java.util.List;

public class ListaProveedoresUseCaseImpl implements ListaProveedoresUseCase {
    private final ProveedorRepository proveedorRepository;

    public ListaProveedoresUseCaseImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.findAll();
    }
}

