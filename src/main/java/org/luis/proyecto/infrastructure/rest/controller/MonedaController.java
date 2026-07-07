package org.luis.proyecto.infrastructure.rest.controller;

import jakarta.validation.Valid;
import org.luis.proyecto.application.usecase.moneda.*;
import org.luis.proyecto.infrastructure.mapper.MonedaMapper;
import org.luis.proyecto.infrastructure.rest.request.MonedaRequest;
import org.luis.proyecto.infrastructure.rest.response.MonedaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/monedas")
public class MonedaController {
    private final CrearMonedaUseCase crearMonedaUseCase;
    private final ListarMonedasUseCase listarMonedasUseCase;
    private final ObtenerMonedaUseCase obtenerMonedaUseCase;
    private final EliminarMonedaUseCase eliminarMonedaUseCase;
    private final ActualizarMonedaUseCase actualizarMonedaUseCase;
    private final MonedaMapper monedaMapper;

    public MonedaController(CrearMonedaUseCase crearMonedaUseCase,
                            ListarMonedasUseCase listarMonedasUseCase,
                            ObtenerMonedaUseCase obtenerMonedaUseCase,
                            EliminarMonedaUseCase eliminarMonedaUseCase,
                            ActualizarMonedaUseCase actualizarMonedaUseCase,
                            MonedaMapper monedaMapper) {
        this.crearMonedaUseCase = crearMonedaUseCase;
        this.listarMonedasUseCase = listarMonedasUseCase;
        this.obtenerMonedaUseCase = obtenerMonedaUseCase;
        this.eliminarMonedaUseCase = eliminarMonedaUseCase;
        this.actualizarMonedaUseCase = actualizarMonedaUseCase;
        this.monedaMapper = monedaMapper;
    }

    @GetMapping
    public ResponseEntity<List<MonedaResponse>> listar() {
        List<MonedaResponse> responses = listarMonedasUseCase.listar().stream()
                .map(monedaMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonedaResponse> obtenerPorId(@PathVariable Integer id) {
        return obtenerMonedaUseCase.obtenerPorId(id)
                .map(moneda -> ResponseEntity.ok(monedaMapper.toResponse(moneda)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MonedaResponse> crear(@Valid @RequestBody MonedaRequest request) {
        var moneda = crearMonedaUseCase.crear(monedaMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(monedaMapper.toResponse(moneda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonedaResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody MonedaRequest request) {
        var moneda = actualizarMonedaUseCase.actualizar(id, monedaMapper.toDomain(request));
        return ResponseEntity.ok(monedaMapper.toResponse(moneda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        eliminarMonedaUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
