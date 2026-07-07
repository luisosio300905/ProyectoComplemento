package org.luis.proyecto.application.usecase.familiaproducto.impl;

import org.luis.proyecto.application.usecase.familiaproducto.ListarFamiliasProductoUseCase;
import org.luis.proyecto.domain.model.FamiliaProducto;
import org.luis.proyecto.domain.repository.FamiliaProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarFamiliasProductoUseCaseImpl implements ListarFamiliasProductoUseCase {
    private final FamiliaProductoRepository familiaProductoRepository;

    public ListarFamiliasProductoUseCaseImpl(FamiliaProductoRepository familiaProductoRepository) {
        this.familiaProductoRepository = familiaProductoRepository;
    }

    @Override
    public List<FamiliaProducto> listar() {
        return familiaProductoRepository.findAll();
    }
}
