package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.balancegeneral.BalanceGeneralService;
import org.luis.proyecto.infrastructure.rest.response.BalanceGeneralResponse;
import org.luis.proyecto.infrastructure.rest.response.EstadoBalanceGeneralResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/balance-general")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BalanceGeneralController {
    private final BalanceGeneralService balanceGeneralService;

    public BalanceGeneralController(BalanceGeneralService balanceGeneralService) {
        this.balanceGeneralService = balanceGeneralService;
    }

    /**
     * Consulta el balance general en tiempo real para una empresa y periodo.
     * Calcula los saldos agrupados por cuenta/subcuenta/divisionaria/subdivisionaria.
     */
    @GetMapping
    public ResponseEntity<EstadoBalanceGeneralResponse> consultarPorPeriodo(
            @RequestParam String empresaId,
            @RequestParam(required = false) Integer ano,
            @RequestParam(required = false) Integer mes) {
        EstadoBalanceGeneralResponse balance = balanceGeneralService.consultarPorPeriodo(empresaId, ano, mes);
        return ResponseEntity.ok(balance);
    }

    /**
     * Obtiene el balance (debe/haber) de un asiento contable específico.
     */
    @GetMapping("/{diaCabCompId}")
    public ResponseEntity<BalanceGeneralResponse> obtenerBalanceAsiento(@PathVariable Long diaCabCompId) {
        BalanceGeneralResponse balance = balanceGeneralService.obtenerBalance(diaCabCompId);

        if (balance == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(balance);
    }
}

