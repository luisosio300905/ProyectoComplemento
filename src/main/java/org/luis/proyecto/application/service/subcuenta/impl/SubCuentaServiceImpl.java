package org.luis.proyecto.application.service.subcuenta.impl;

import org.luis.proyecto.application.service.subcuenta.SubCuentaService;
import org.luis.proyecto.domain.model.SubCuenta;
import org.luis.proyecto.domain.repository.SubCuentaRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.infrastructure.persistence.entity.SubCuentaPK;

import java.util.List;

public class SubCuentaServiceImpl implements SubCuentaService {
    private final SubCuentaRepository subCuentaRepository;

    public SubCuentaServiceImpl(SubCuentaRepository subCuentaRepository) {
        this.subCuentaRepository = subCuentaRepository;
    }

    @Override
    public SubCuenta crear(SubCuenta subCuenta) {
        return subCuentaRepository.save(subCuenta);
    }

    @Override
    public SubCuenta actualizar(SubCuentaPK id, SubCuenta subCuenta) {
        subCuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubCuenta no encontrada"));
        return subCuentaRepository.save(subCuenta);
    }

    @Override
    public void eliminar(SubCuentaPK id) {
        subCuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubCuenta no encontrada"));
        subCuentaRepository.deleteById(id);
    }

    @Override
    public SubCuenta obtenerById(SubCuentaPK id) {
        return subCuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubCuenta no encontrada"));
    }

    @Override
    public List<SubCuenta> obtenerTodos() {
        return subCuentaRepository.findAll();
    }

    @Override
    public List<SubCuenta> obtenerPorCuentaId(String cuentaId) {
        return subCuentaRepository.findByCuentaId(cuentaId);
    }

    @Override
    public void eliminarPorCuentaId(String cuentaId) {
        subCuentaRepository.deleteByCuentaId(cuentaId);
    }
}

