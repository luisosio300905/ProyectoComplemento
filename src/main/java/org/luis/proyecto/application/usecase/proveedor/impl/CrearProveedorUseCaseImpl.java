package org.luis.proyecto.application.usecase.proveedor.impl;

import org.luis.proyecto.application.usecase.proveedor.CrearProveedorUseCase;
import org.luis.proyecto.domain.model.Proveedor;
import org.luis.proyecto.domain.repository.ProveedorRepository;

public class CrearProveedorUseCaseImpl implements CrearProveedorUseCase {
    private final ProveedorRepository proveedorRepository;

    public CrearProveedorUseCaseImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public Proveedor crear(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }
}

