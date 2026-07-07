package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.subcuenta.SubCuentaService;
import org.luis.proyecto.infrastructure.mapper.SubCuentaMapper;
import org.luis.proyecto.infrastructure.persistence.entity.SubCuentaPK;
import org.luis.proyecto.infrastructure.rest.request.SubCuentaRequest;
import org.luis.proyecto.infrastructure.rest.response.SubCuentaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcuenta")
public class SubCuentaController {
    private final SubCuentaService subCuentaService;
    private final SubCuentaMapper subCuentaMapper;

    public SubCuentaController(SubCuentaService subCuentaService, SubCuentaMapper subCuentaMapper) {
        this.subCuentaService = subCuentaService;
        this.subCuentaMapper = subCuentaMapper;
    }

    @GetMapping
    public ResponseEntity<List<SubCuentaResponse>> obtenerTodos() {
        return ResponseEntity.ok(subCuentaMapper.toSubCuentaResponseList(subCuentaService.obtenerTodos()));
    }

    @PostMapping
    public ResponseEntity<SubCuentaResponse> crear(@RequestBody SubCuentaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subCuentaMapper.toSubCuentaResponse(subCuentaService.crear(subCuentaMapper.toSubCuenta(request))));
    }

    @GetMapping("/{cuentaId}/{subCtaId}")
    public ResponseEntity<SubCuentaResponse> obtenerById(@PathVariable String cuentaId, @PathVariable String subCtaId) {
        SubCuentaPK id = new SubCuentaPK(cuentaId, subCtaId);
        return ResponseEntity.ok(subCuentaMapper.toSubCuentaResponse(subCuentaService.obtenerById(id)));
    }

    @GetMapping("/cuenta/{cuentaId}")
    public ResponseEntity<List<SubCuentaResponse>> obtenerPorCuentaId(@PathVariable String cuentaId) {
        return ResponseEntity.ok(subCuentaMapper.toSubCuentaResponseList(subCuentaService.obtenerPorCuentaId(cuentaId)));
    }

    @PutMapping("/{cuentaId}/{subCtaId}")
    public ResponseEntity<SubCuentaResponse> actualizar(@PathVariable String cuentaId, @PathVariable String subCtaId, @RequestBody SubCuentaRequest request) {
        SubCuentaPK id = new SubCuentaPK(cuentaId, subCtaId);
        return ResponseEntity.ok(subCuentaMapper.toSubCuentaResponse(
                subCuentaService.actualizar(id, subCuentaMapper.toSubCuenta(request))));
    }

    @DeleteMapping("/{cuentaId}/{subCtaId}")
    public ResponseEntity<Void> eliminar(@PathVariable String cuentaId, @PathVariable String subCtaId) {
        SubCuentaPK id = new SubCuentaPK(cuentaId, subCtaId);
        subCuentaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cuenta/{cuentaId}")
    public ResponseEntity<Void> eliminarPorCuentaId(@PathVariable String cuentaId) {
        subCuentaService.eliminarPorCuentaId(cuentaId);
        return ResponseEntity.noContent().build();
    }
}

