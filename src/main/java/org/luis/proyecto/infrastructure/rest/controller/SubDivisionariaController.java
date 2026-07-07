package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.subdivisionaria.SubDivisionariaService;
import org.luis.proyecto.infrastructure.mapper.SubDivisionariaMapper;
import org.luis.proyecto.infrastructure.persistence.entity.SubDivisionariaPK;
import org.luis.proyecto.infrastructure.rest.request.SubDivisionariaRequest;
import org.luis.proyecto.infrastructure.rest.response.SubDivisionariaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subdivisionaria")
public class SubDivisionariaController {
    private final SubDivisionariaService subDivisionariaService;
    private final SubDivisionariaMapper subDivisionariaMapper;

    public SubDivisionariaController(SubDivisionariaService subDivisionariaService, SubDivisionariaMapper subDivisionariaMapper) {
        this.subDivisionariaService = subDivisionariaService;
        this.subDivisionariaMapper = subDivisionariaMapper;
    }

    @GetMapping
    public ResponseEntity<List<SubDivisionariaResponse>> obtenerTodos() {
        return ResponseEntity.ok(subDivisionariaMapper.toSubDivisionariaResponseList(subDivisionariaService.obtenerTodos()));
    }

    @PostMapping
    public ResponseEntity<SubDivisionariaResponse> crear(@RequestBody SubDivisionariaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subDivisionariaMapper.toSubDivisionariaResponse(subDivisionariaService.crear(subDivisionariaMapper.toSubDivisionaria(request))));
    }

    @GetMapping("/{cuentaId}/{subCtaId}/{divisioId}/{subDivId}")
    public ResponseEntity<SubDivisionariaResponse> obtenerById(@PathVariable String cuentaId, @PathVariable String subCtaId, @PathVariable String divisioId, @PathVariable String subDivId) {
        SubDivisionariaPK id = new SubDivisionariaPK(cuentaId, subCtaId, divisioId, subDivId);
        return ResponseEntity.ok(subDivisionariaMapper.toSubDivisionariaResponse(subDivisionariaService.obtenerById(id)));
    }

    @GetMapping("/divisionaria/{cuentaId}/{subCtaId}/{divisioId}")
    public ResponseEntity<List<SubDivisionariaResponse>> obtenerPorDivisionaria(@PathVariable String cuentaId, @PathVariable String subCtaId, @PathVariable String divisioId) {
        return ResponseEntity.ok(subDivisionariaMapper.toSubDivisionariaResponseList(
                subDivisionariaService.obtenerPorDivisionaria(cuentaId, subCtaId, divisioId)));
    }

    @PutMapping("/{cuentaId}/{subCtaId}/{divisioId}/{subDivId}")
    public ResponseEntity<SubDivisionariaResponse> actualizar(@PathVariable String cuentaId, @PathVariable String subCtaId, @PathVariable String divisioId, @PathVariable String subDivId, @RequestBody SubDivisionariaRequest request) {
        SubDivisionariaPK id = new SubDivisionariaPK(cuentaId, subCtaId, divisioId, subDivId);
        return ResponseEntity.ok(subDivisionariaMapper.toSubDivisionariaResponse(
                subDivisionariaService.actualizar(id, subDivisionariaMapper.toSubDivisionaria(request))));
    }

    @DeleteMapping("/{cuentaId}/{subCtaId}/{divisioId}/{subDivId}")
    public ResponseEntity<Void> eliminar(@PathVariable String cuentaId, @PathVariable String subCtaId, @PathVariable String divisioId, @PathVariable String subDivId) {
        SubDivisionariaPK id = new SubDivisionariaPK(cuentaId, subCtaId, divisioId, subDivId);
        subDivisionariaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/divisionaria/{cuentaId}/{subCtaId}/{divisioId}")
    public ResponseEntity<Void> eliminarPorDivisionaria(@PathVariable String cuentaId, @PathVariable String subCtaId, @PathVariable String divisioId) {
        subDivisionariaService.eliminarPorDivisionaria(cuentaId, subCtaId, divisioId);
        return ResponseEntity.noContent().build();
    }
}

