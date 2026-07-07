package org.luis.proyecto.application.usecase.familiaproducto.impl;

import org.luis.proyecto.application.usecase.familiaproducto.EliminarFamiliaProductoUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.repository.FamiliaProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarFamiliaProductoUseCaseImpl implements EliminarFamiliaProductoUseCase {
    private final FamiliaProductoRepository familiaProductoRepository;

    public EliminarFamiliaProductoUseCaseImpl(FamiliaProductoRepository familiaProductoRepository) {
        this.familiaProductoRepository = familiaProductoRepository;
    }

    @Override
    public void eliminar(Integer id) {
        if (familiaProductoRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("FamiliaProducto no encontrado con id " + id);
        }
        familiaProductoRepository.deleteById(id);
    }
}
