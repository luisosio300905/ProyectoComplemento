package org.luis.proyecto.application.service.balancegeneral;

import org.luis.proyecto.infrastructure.rest.response.BalanceGeneralResponse;
import org.luis.proyecto.infrastructure.rest.response.EstadoBalanceGeneralResponse;

public interface BalanceGeneralService {
    /**
     * Obtiene el balance (totales de debe y haber) para un asiento específico.
     */
    BalanceGeneralResponse obtenerBalance(Long diaCabCompId);

    /**
     * Calcula el balance general en tiempo real agrupando todos los DiarioDetalle
     * de una empresa y periodo (año/mes). Los parámetros de periodo son opcionales.
     */
    EstadoBalanceGeneralResponse consultarPorPeriodo(String empresaId, Integer ano, Integer mes);
}

