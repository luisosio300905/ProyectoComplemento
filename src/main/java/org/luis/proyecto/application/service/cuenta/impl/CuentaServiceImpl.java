package org.luis.proyecto.application.service.cuenta.impl;

import org.luis.proyecto.application.service.cuenta.CuentaService;
import org.luis.proyecto.domain.model.Cuenta;
import org.luis.proyecto.domain.repository.CuentaRepository;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;

import java.util.List;

public class CuentaServiceImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Cuenta crear(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta actualizar(String id, Cuenta cuenta) {
        cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
        cuenta.setCuentaId(id);
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void eliminar(String id) {
        cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
        cuentaRepository.deleteById(id);
    }

    @Override
    public Cuenta obtenerById(String id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
    }

    @Override
    public List<Cuenta> obtenerTodos() {
        return cuentaRepository.findAll();
    }
}

