package org.luis.proyecto.application.usecase.proveedor.impl;

import org.luis.proyecto.application.usecase.proveedor.ActualizarProveedorUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Proveedor;
import org.luis.proyecto.domain.repository.ProveedorRepository;

public class ActualizarProveedorUseCaseImpl implements ActualizarProveedorUseCase {
    private final ProveedorRepository proveedorRepository;

    public ActualizarProveedorUseCaseImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public Proveedor actualizar(Integer id, Proveedor proveedor) {
        Proveedor proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado"));
        
        proveedor.setId(id);
        return proveedorRepository.save(proveedor);
    }
}

