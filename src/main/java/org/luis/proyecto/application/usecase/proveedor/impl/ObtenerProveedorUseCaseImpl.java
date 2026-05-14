package org.luis.proyecto.application.usecase.proveedor.impl;

import org.luis.proyecto.application.usecase.proveedor.ObtenerProveedorUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Proveedor;
import org.luis.proyecto.domain.repository.ProveedorRepository;

public class ObtenerProveedorUseCaseImpl implements ObtenerProveedorUseCase {
    private final ProveedorRepository proveedorRepository;

    public ObtenerProveedorUseCaseImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public Proveedor obtenerProveedor(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado"));
    }
}

