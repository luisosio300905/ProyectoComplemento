package org.luis.proyecto.application.usecase.proveedor.impl;

import org.luis.proyecto.application.usecase.proveedor.EliminarProveedorUseCase;
import org.luis.proyecto.domain.repository.ProveedorRepository;

public class EliminarProveedorUseCaseImpl implements EliminarProveedorUseCase {
    private final ProveedorRepository proveedorRepository;

    public EliminarProveedorUseCaseImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public void eliminar(Integer id) {
        proveedorRepository.deleteById(id);
    }
}

