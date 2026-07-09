package org.luis.proyecto.application.service.balancegeneral.impl;

import org.luis.proyecto.application.service.balancegeneral.BalanceGeneralService;
import org.luis.proyecto.application.usecase.diariocabecera.ObtenerBalanceGeneralUseCase;
import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.model.SaldoCuenta;
import org.luis.proyecto.domain.repository.DiarioDetalleRepository;
import org.luis.proyecto.infrastructure.rest.response.BalanceGeneralResponse;
import org.luis.proyecto.infrastructure.rest.response.EstadoBalanceGeneralResponse;
import org.luis.proyecto.infrastructure.rest.response.SaldoCuentaResponse;

import java.math.BigDecimal;
import java.util.List;

public class BalanceGeneralServiceImpl implements BalanceGeneralService {
    private final ObtenerBalanceGeneralUseCase obtenerBalanceGeneralUseCase;
    private final DiarioDetalleRepository diarioDetalleRepository;

    public BalanceGeneralServiceImpl(ObtenerBalanceGeneralUseCase obtenerBalanceGeneralUseCase,
                                     DiarioDetalleRepository diarioDetalleRepository) {
        this.obtenerBalanceGeneralUseCase = obtenerBalanceGeneralUseCase;
        this.diarioDetalleRepository = diarioDetalleRepository;
    }

    @Override
    public BalanceGeneralResponse obtenerBalance(Long diaCabCompId) {
        // Obtener cabecera
        DiarioCabecera cabecera = obtenerBalanceGeneralUseCase.obtenerConDetalles(diaCabCompId);

        if (cabecera == null) {
            return null;
        }

        // Consultar los detalles directamente desde el repositorio para evitar problemas de caché de Hibernate
        List<DiarioDetalle> detalles = diarioDetalleRepository.findByDiaCabCompId(diaCabCompId);

        // Calcular totales de debe y haber
        BigDecimal totalDebe = BigDecimal.ZERO;
        BigDecimal totalHaber = BigDecimal.ZERO;

        for (DiarioDetalle detalle : detalles) {
            if (detalle.getDiaDetDebe() != null) {
                totalDebe = totalDebe.add(detalle.getDiaDetDebe());
            }
            if (detalle.getDiaDetHaber() != null) {
                totalHaber = totalHaber.add(detalle.getDiaDetHaber());
            }
        }

        // Construir respuesta con los totales
        return new BalanceGeneralResponse(
            cabecera.getDiaCabCompId(),
            cabecera.getDiaCabGlosa(),
            totalDebe,
            totalHaber,
            detalles.size()
        );
    }

    @Override
    public EstadoBalanceGeneralResponse consultarPorPeriodo(String empresaId, Integer ano, Integer mes) {
        List<SaldoCuenta> saldos = diarioDetalleRepository.obtenerSaldos(empresaId, ano, mes);

        BigDecimal totalDebe = BigDecimal.ZERO;
        BigDecimal totalHaber = BigDecimal.ZERO;

        List<SaldoCuentaResponse> saldoResponses = saldos.stream()
                .map(SaldoCuentaResponse::from)
                .toList();

        for (SaldoCuenta saldo : saldos) {
            if (saldo.getTotalDebe() != null) {
                totalDebe = totalDebe.add(saldo.getTotalDebe());
            }
            if (saldo.getTotalHaber() != null) {
                totalHaber = totalHaber.add(saldo.getTotalHaber());
            }
        }

        return new EstadoBalanceGeneralResponse(empresaId, ano, mes, totalDebe, totalHaber, saldoResponses);
    }
}

