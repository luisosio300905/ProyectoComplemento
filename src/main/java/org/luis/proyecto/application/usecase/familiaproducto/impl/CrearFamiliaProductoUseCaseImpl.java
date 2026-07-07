package org.luis.proyecto.application.usecase.familiaproducto.impl;

import org.luis.proyecto.application.usecase.familiaproducto.CrearFamiliaProductoUseCase;
import org.luis.proyecto.domain.model.FamiliaProducto;
import org.luis.proyecto.domain.repository.FamiliaProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class CrearFamiliaProductoUseCaseImpl implements CrearFamiliaProductoUseCase {
    private final FamiliaProductoRepository familiaProductoRepository;

    public CrearFamiliaProductoUseCaseImpl(FamiliaProductoRepository familiaProductoRepository) {
        this.familiaProductoRepository = familiaProductoRepository;
    }

    @Override
    public FamiliaProducto crear(FamiliaProducto familiaProducto) {
        return familiaProductoRepository.save(familiaProducto);
    }
}
