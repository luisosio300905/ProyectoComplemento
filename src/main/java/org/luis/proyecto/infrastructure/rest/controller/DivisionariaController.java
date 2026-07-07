package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.divisionaria.DivisionariaService;
import org.luis.proyecto.infrastructure.mapper.DivisionariaMapper;
import org.luis.proyecto.infrastructure.persistence.entity.DivisionariaPK;
import org.luis.proyecto.infrastructure.rest.request.DivisionariaRequest;
import org.luis.proyecto.infrastructure.rest.response.DivisionariaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisionaria")
public class DivisionariaController {
    private final DivisionariaService divisionariaService;
    private final DivisionariaMapper divisionariaMapper;

    public DivisionariaController(DivisionariaService divisionariaService, DivisionariaMapper divisionariaMapper) {
        this.divisionariaService = divisionariaService;
        this.divisionariaMapper = divisionariaMapper;
    }

    @GetMapping
    public ResponseEntity<List<DivisionariaResponse>> obtenerTodos() {
        return ResponseEntity.ok(divisionariaMapper.toDivisionariaResponseList(divisionariaService.obtenerTodos()));
    }

    @PostMapping
    public ResponseEntity<DivisionariaResponse> crear(@RequestBody DivisionariaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(divisionariaMapper.toDivisionariaResponse(divisionariaService.crear(divisionariaMapper.toDivisionaria(request))));
    }

    @GetMapping("/{cuentaId}/{subCtaId}/{divisioId}")
    public ResponseEntity<DivisionariaResponse> obtenerById(@PathVariable String cuentaId, @PathVariable String subCtaId, @PathVariable String divisioId) {
        DivisionariaPK id = new DivisionariaPK(cuentaId, subCtaId, divisioId);
        return ResponseEntity.ok(divisionariaMapper.toDivisionariaResponse(divisionariaService.obtenerById(id)));
    }

    @GetMapping("/subcuenta/{cuentaId}/{subCtaId}")
    public ResponseEntity<List<DivisionariaResponse>> obtenerPorSubCuenta(@PathVariable String cuentaId, @PathVariable String subCtaId) {
        return ResponseEntity.ok(divisionariaMapper.toDivisionariaResponseList(
                divisionariaService.obtenerPorSubCuenta(cuentaId, subCtaId)));
    }

    @PutMapping("/{cuentaId}/{subCtaId}/{divisioId}")
    public ResponseEntity<DivisionariaResponse> actualizar(@PathVariable String cuentaId, @PathVariable String subCtaId, @PathVariable String divisioId, @RequestBody DivisionariaRequest request) {
        DivisionariaPK id = new DivisionariaPK(cuentaId, subCtaId, divisioId);
        return ResponseEntity.ok(divisionariaMapper.toDivisionariaResponse(
                divisionariaService.actualizar(id, divisionariaMapper.toDivisionaria(request))));
    }

    @DeleteMapping("/{cuentaId}/{subCtaId}/{divisioId}")
    public ResponseEntity<Void> eliminar(@PathVariable String cuentaId, @PathVariable String subCtaId, @PathVariable String divisioId) {
        DivisionariaPK id = new DivisionariaPK(cuentaId, subCtaId, divisioId);
        divisionariaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/subcuenta/{cuentaId}/{subCtaId}")
    public ResponseEntity<Void> eliminarPorSubCuenta(@PathVariable String cuentaId, @PathVariable String subCtaId) {
        divisionariaService.eliminarPorSubCuenta(cuentaId, subCtaId);
        return ResponseEntity.noContent().build();
    }
}

