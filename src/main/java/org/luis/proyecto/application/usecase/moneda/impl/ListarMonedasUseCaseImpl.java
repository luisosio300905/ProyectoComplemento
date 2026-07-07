package org.luis.proyecto.application.usecase.moneda.impl;

import org.luis.proyecto.application.usecase.moneda.ListarMonedasUseCase;
import org.luis.proyecto.domain.model.Moneda;
import org.luis.proyecto.domain.repository.MonedaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarMonedasUseCaseImpl implements ListarMonedasUseCase {
    private final MonedaRepository monedaRepository;

    public ListarMonedasUseCaseImpl(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    @Override
    public List<Moneda> listar() {
        return monedaRepository.findAll();
    }
}
