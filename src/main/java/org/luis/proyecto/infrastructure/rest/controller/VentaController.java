package org.luis.proyecto.infrastructure.rest.controller;


import java.util.List;

import org.luis.proyecto.application.service.venta.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.luis.proyecto.infrastructure.mapper.VentaMapper;
import org.luis.proyecto.infrastructure.rest.request.VentaRequest;
import org.luis.proyecto.infrastructure.rest.response.VentaResponse;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
    private final VentaService ventaService;
    private final VentaMapper ventaMapper;

    public VentaController(VentaService ventaService, VentaMapper ventaMapper) {
        this.ventaService = ventaService;
        this.ventaMapper = ventaMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<VentaResponse>> getVentas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ventaMapper.toVentaResponseList(ventaService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<VentaResponse> createVenta(@RequestBody VentaRequest ventaRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ventaMapper.toVentaResponse(
                        ventaService.crear(ventaMapper.toVenta(ventaRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaResponse> getventa(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ventaMapper.toVentaResponse(ventaService.obtenerVenta(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaResponse> updateVenta(@PathVariable Integer id, @RequestBody VentaRequest ventaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ventaMapper.toVentaResponse(
                        ventaService.actualizar(id, ventaMapper.toVenta(ventaRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
        ventaService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
