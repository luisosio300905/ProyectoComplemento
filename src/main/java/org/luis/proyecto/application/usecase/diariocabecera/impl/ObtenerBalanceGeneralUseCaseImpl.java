package org.luis.proyecto.application.usecase.diariocabecera.impl;

import org.luis.proyecto.application.usecase.diariocabecera.ObtenerBalanceGeneralUseCase;
import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.domain.repository.DiarioCabeceraRepository;

public class ObtenerBalanceGeneralUseCaseImpl implements ObtenerBalanceGeneralUseCase {
    private final DiarioCabeceraRepository diarioCabeceraRepository;

    public ObtenerBalanceGeneralUseCaseImpl(DiarioCabeceraRepository diarioCabeceraRepository) {
        this.diarioCabeceraRepository = diarioCabeceraRepository;
    }

    @Override
    public DiarioCabecera obtenerConDetalles(Long diaCabCompId) {
        // Obtener la cabecera con sus detalles asociados
        // El repositorio carga automáticamente los detalles gracias a la relación OneToMany
        return diarioCabeceraRepository.findById(diaCabCompId).orElse(null);
    }
}


