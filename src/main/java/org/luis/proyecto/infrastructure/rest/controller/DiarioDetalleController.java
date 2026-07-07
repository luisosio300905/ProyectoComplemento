package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.diariodetalle.DiarioDetalleService;
import org.luis.proyecto.infrastructure.mapper.DiarioDetalleMapper;
import org.luis.proyecto.infrastructure.rest.request.DiarioDetalleRequest;
import org.luis.proyecto.infrastructure.rest.response.DiarioDetalleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diario-detalle")
public class DiarioDetalleController {
    private final DiarioDetalleService diarioDetalleService;
    private final DiarioDetalleMapper diarioDetalleMapper;

    public DiarioDetalleController(DiarioDetalleService diarioDetalleService, DiarioDetalleMapper diarioDetalleMapper) {
        this.diarioDetalleService = diarioDetalleService;
        this.diarioDetalleMapper = diarioDetalleMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<DiarioDetalleResponse>> obtenerTodos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioDetalleMapper.toDiarioDetalleResponseList(diarioDetalleService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<DiarioDetalleResponse> crear(@RequestBody DiarioDetalleRequest diarioDetalleRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(diarioDetalleMapper.toDiarioDetalleResponse(
                        diarioDetalleService.crear(diarioDetalleMapper.toDiarioDetalle(diarioDetalleRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiarioDetalleResponse> obtenerById(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioDetalleMapper.toDiarioDetalleResponse(diarioDetalleService.obtenerById(id)));
    }

    @GetMapping("/cabecera/{diaCabCompId}")
    public ResponseEntity<List<DiarioDetalleResponse>> obtenerPorDiaCabCompId(@PathVariable Long diaCabCompId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioDetalleMapper.toDiarioDetalleResponseList(diarioDetalleService.obtenerPorDiaCabCompId(diaCabCompId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiarioDetalleResponse> actualizar(@PathVariable Integer id, @RequestBody DiarioDetalleRequest diarioDetalleRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(diarioDetalleMapper.toDiarioDetalleResponse(
                        diarioDetalleService.actualizar(id, diarioDetalleMapper.toDiarioDetalle(diarioDetalleRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        diarioDetalleService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/cabecera/{diaCabCompId}")
    public ResponseEntity<Void> eliminarPorDiaCabCompId(@PathVariable Long diaCabCompId) {
        diarioDetalleService.eliminarPorDiaCabCompId(diaCabCompId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

