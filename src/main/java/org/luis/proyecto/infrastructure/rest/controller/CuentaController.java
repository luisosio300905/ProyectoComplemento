package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.cuenta.CuentaService;
import org.luis.proyecto.infrastructure.mapper.CuentaMapper;
import org.luis.proyecto.infrastructure.rest.request.CuentaRequest;
import org.luis.proyecto.infrastructure.rest.response.CuentaResponse;
import org.luis.proyecto.infrastructure.rest.response.CuentaJerarquiaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {
    private final CuentaService cuentaService;
    private final CuentaMapper cuentaMapper;

    public CuentaController(CuentaService cuentaService, CuentaMapper cuentaMapper) {
        this.cuentaService = cuentaService;
        this.cuentaMapper = cuentaMapper;
    }

    @GetMapping
    public ResponseEntity<List<CuentaResponse>> obtenerTodos() {
        return ResponseEntity.ok(cuentaMapper.toCuentaResponseList(cuentaService.obtenerTodos()));
    }

    @GetMapping("/jerarquia")
    public ResponseEntity<List<CuentaJerarquiaResponse>> obtenerJerarquia() {
        return ResponseEntity.ok(cuentaService.obtenerJerarquia());
    }

    @PostMapping
    public ResponseEntity<CuentaResponse> crear(@RequestBody CuentaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cuentaMapper.toCuentaResponse(cuentaService.crear(cuentaMapper.toCuenta(request))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaResponse> obtenerById(@PathVariable String id) {
        return ResponseEntity.ok(cuentaMapper.toCuentaResponse(cuentaService.obtenerById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaResponse> actualizar(@PathVariable String id, @RequestBody CuentaRequest request) {
        return ResponseEntity.ok(cuentaMapper.toCuentaResponse(
                cuentaService.actualizar(id, cuentaMapper.toCuenta(request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        cuentaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

