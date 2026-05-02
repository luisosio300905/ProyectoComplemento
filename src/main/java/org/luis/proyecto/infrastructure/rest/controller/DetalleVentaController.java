package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.detalleventa.DetalleVentaService;
import org.luis.proyecto.infrastructure.mapper.DetalleVentaMapper;
import org.luis.proyecto.infrastructure.rest.request.DetalleVentaRequest;
import org.luis.proyecto.infrastructure.rest.response.DetalleVentaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleventa")
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;
    private final DetalleVentaMapper detalleVentaMapper;

    public DetalleVentaController(DetalleVentaService detalleVentaService, DetalleVentaMapper detalleVentaMapper) {
        this.detalleVentaService = detalleVentaService;
        this.detalleVentaMapper = detalleVentaMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<DetalleVentaResponse>> getDetallesVenta() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalleVentaMapper.toDetalleVentaResponseList(detalleVentaService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<DetalleVentaResponse> createDetalleVenta(@RequestBody DetalleVentaRequest detalleVentaRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(detalleVentaMapper.toDetalleVentaResponse(
                        detalleVentaService.crear(detalleVentaMapper.toDetalleVenta(detalleVentaRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaResponse> getDetalleVenta(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalleVentaMapper.toDetalleVentaResponse(detalleVentaService.obtenerDetalleVenta(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentaResponse> updateDetalleVenta(@PathVariable Integer id, @RequestBody DetalleVentaRequest detalleVentaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalleVentaMapper.toDetalleVentaResponse(
                        detalleVentaService.actualizar(id, detalleVentaMapper.toDetalleVenta(detalleVentaRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable Integer id) {
        detalleVentaService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}