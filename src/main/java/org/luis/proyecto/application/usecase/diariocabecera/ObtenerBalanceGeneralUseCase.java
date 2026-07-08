package org.luis.proyecto.application.usecase.diariocabecera;

import org.luis.proyecto.domain.model.DiarioCabecera;

public interface ObtenerBalanceGeneralUseCase {
    /**
     * Obtiene la cabecera del diario y calcula los totales de debe y haber.
     * @param diaCabCompId ID de la cabecera del diario
     * @return Objeto DiarioCabecera con detalles cargados (para poder calcular totales)
     */
    DiarioCabecera obtenerConDetalles(Long diaCabCompId);
}

