package org.luis.proyecto.application.usecase.moneda.impl;

import org.luis.proyecto.application.usecase.moneda.ObtenerMonedaUseCase;
import org.luis.proyecto.domain.model.Moneda;
import org.luis.proyecto.domain.repository.MonedaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObtenerMonedaUseCaseImpl implements ObtenerMonedaUseCase {
    private final MonedaRepository monedaRepository;

    public ObtenerMonedaUseCaseImpl(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    @Override
    public Optional<Moneda> obtenerPorId(Integer id) {
        return monedaRepository.findById(id);
    }
}
