package org.luis.proyecto.application.usecase.familiaproducto.impl;

import org.luis.proyecto.application.usecase.familiaproducto.ActualizarFamiliaProductoUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.FamiliaProducto;
import org.luis.proyecto.domain.repository.FamiliaProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ActualizarFamiliaProductoUseCaseImpl implements ActualizarFamiliaProductoUseCase {
    private final FamiliaProductoRepository familiaProductoRepository;

    public ActualizarFamiliaProductoUseCaseImpl(FamiliaProductoRepository familiaProductoRepository) {
        this.familiaProductoRepository = familiaProductoRepository;
    }

    @Override
    public FamiliaProducto actualizar(Integer id, FamiliaProducto familiaProducto) {
        FamiliaProducto existente = familiaProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FamiliaProducto no encontrado con id " + id));
        existente.setFamDescripcion(familiaProducto.getFamDescripcion());
        existente.setFamEstado(familiaProducto.getFamEstado());
        existente.setCodfam(familiaProducto.getCodfam());
        existente.setUsrSistema(familiaProducto.getUsrSistema());
        existente.setFecSistema(familiaProducto.getFecSistema());
        existente.setHrsSistema(familiaProducto.getHrsSistema());

        return familiaProductoRepository.save(existente);
    }
}
