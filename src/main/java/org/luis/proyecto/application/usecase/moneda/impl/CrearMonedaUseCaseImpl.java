package org.luis.proyecto.application.usecase.moneda.impl;

import org.luis.proyecto.application.usecase.moneda.CrearMonedaUseCase;
import org.luis.proyecto.domain.model.Moneda;
import org.luis.proyecto.domain.repository.MonedaRepository;
import org.springframework.stereotype.Service;

@Service
public class CrearMonedaUseCaseImpl implements CrearMonedaUseCase {
    private final MonedaRepository monedaRepository;

    public CrearMonedaUseCaseImpl(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    @Override
    public Moneda crear(Moneda moneda) {
        return monedaRepository.save(moneda);
    }
}
