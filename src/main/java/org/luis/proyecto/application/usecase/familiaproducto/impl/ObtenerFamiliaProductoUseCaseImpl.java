package org.luis.proyecto.application.usecase.familiaproducto.impl;

import org.luis.proyecto.application.usecase.familiaproducto.ObtenerFamiliaProductoUseCase;
import org.luis.proyecto.domain.model.FamiliaProducto;
import org.luis.proyecto.domain.repository.FamiliaProductoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObtenerFamiliaProductoUseCaseImpl implements ObtenerFamiliaProductoUseCase {
    private final FamiliaProductoRepository familiaProductoRepository;

    public ObtenerFamiliaProductoUseCaseImpl(FamiliaProductoRepository familiaProductoRepository) {
        this.familiaProductoRepository = familiaProductoRepository;
    }

    @Override
    public Optional<FamiliaProducto> obtenerPorId(Integer id) {
        return familiaProductoRepository.findById(id);
    }
}
