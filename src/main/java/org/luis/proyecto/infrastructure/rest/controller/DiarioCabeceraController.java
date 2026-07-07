package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.diariocabecera.DiarioCabeceraService;
import org.luis.proyecto.infrastructure.mapper.DiarioCabeceraMapper;
import org.luis.proyecto.infrastructure.rest.request.DiarioCabeceraRequest;
import org.luis.proyecto.infrastructure.rest.response.DiarioCabeceraResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diario-cabecera")
public class DiarioCabeceraController {
    private final DiarioCabeceraService diarioCabeceraService;
    private final DiarioCabeceraMapper diarioCabeceraMapper;

    public DiarioCabeceraController(DiarioCabeceraService diarioCabeceraService, DiarioCabeceraMapper diarioCabeceraMapper) {
        this.diarioCabeceraService = diarioCabeceraService;
        this.diarioCabeceraMapper = diarioCabeceraMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<DiarioCabeceraResponse>> obtenerTodos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponseList(diarioCabeceraService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<DiarioCabeceraResponse> crear(@RequestBody DiarioCabeceraRequest diarioCabeceraRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponse(
                        diarioCabeceraService.crear(diarioCabeceraMapper.toDiarioCabecera(diarioCabeceraRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiarioCabeceraResponse> obtenerById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponse(diarioCabeceraService.obtenerById(id)));
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<DiarioCabeceraResponse> obtenerByEmpresaId(@PathVariable String empresaId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponse(diarioCabeceraService.obtenerByEmpresaId(empresaId)));
    }

    @GetMapping("/periodo/{ano}/{mes}")
    public ResponseEntity<List<DiarioCabeceraResponse>> obtenerPorAnoYMes(@PathVariable Integer ano, @PathVariable Integer mes) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponseList(diarioCabeceraService.obtenerPorAnoYMes(ano, mes)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiarioCabeceraResponse> actualizar(@PathVariable Long id, @RequestBody DiarioCabeceraRequest diarioCabeceraRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioCabeceraMapper.toDiarioCabeceraResponse(
                        diarioCabeceraService.actualizar(id, diarioCabeceraMapper.toDiarioCabecera(diarioCabeceraRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        diarioCabeceraService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

