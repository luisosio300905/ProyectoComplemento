package org.luis.proyecto.application.usecase.moneda.impl;

import org.luis.proyecto.application.usecase.moneda.ActualizarMonedaUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Moneda;
import org.luis.proyecto.domain.repository.MonedaRepository;
import org.springframework.stereotype.Service;

@Service
public class ActualizarMonedaUseCaseImpl implements ActualizarMonedaUseCase {
    private final MonedaRepository monedaRepository;

    public ActualizarMonedaUseCaseImpl(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    @Override
    public Moneda actualizar(Integer id, Moneda moneda) {
        Moneda existente = monedaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moneda no encontrado con id " + id));
        existente.setMonedaDescripcion(moneda.getMonedaDescripcion());
        existente.setMonedaAbrev(moneda.getMonedaAbrev());
        existente.setMonedaEst(moneda.getMonedaEst());
        existente.setMonedaAbrevSunat(moneda.getMonedaAbrevSunat());
        existente.setUsrSistema(moneda.getUsrSistema());
        existente.setFecSistema(moneda.getFecSistema());
        existente.setHrsSistema(moneda.getHrsSistema());

        return monedaRepository.save(existente);
    }
}
