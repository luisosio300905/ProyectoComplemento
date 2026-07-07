package org.luis.proyecto.application.usecase.moneda.impl;

import org.luis.proyecto.application.usecase.moneda.EliminarMonedaUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.repository.MonedaRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarMonedaUseCaseImpl implements EliminarMonedaUseCase {
    private final MonedaRepository monedaRepository;

    public EliminarMonedaUseCaseImpl(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    @Override
    public void eliminar(Integer id) {
        if (monedaRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Moneda no encontrado con id " + id);
        }
        monedaRepository.deleteById(id);
    }
}
