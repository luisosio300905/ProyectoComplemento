package org.luis.proyecto.infrastructure.rest.controller;

import jakarta.validation.Valid;
import org.luis.proyecto.application.usecase.laboratorio.*;
import org.luis.proyecto.infrastructure.mapper.LaboratorioMapper;
import org.luis.proyecto.infrastructure.rest.request.LaboratorioRequest;
import org.luis.proyecto.infrastructure.rest.response.LaboratorioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/laboratorios")
public class LaboratorioController {
    private final CrearLaboratorioUseCase crearLaboratorioUseCase;
    private final ListarLaboratoriosUseCase listarLaboratoriosUseCase;
    private final ObtenerLaboratorioUseCase obtenerLaboratorioUseCase;
    private final EliminarLaboratorioUseCase eliminarLaboratorioUseCase;
    private final ActualizarLaboratorioUseCase actualizarLaboratorioUseCase;
    private final LaboratorioMapper laboratorioMapper;

    public LaboratorioController(CrearLaboratorioUseCase crearLaboratorioUseCase,
                                 ListarLaboratoriosUseCase listarLaboratoriosUseCase,
                                 ObtenerLaboratorioUseCase obtenerLaboratorioUseCase,
                                 EliminarLaboratorioUseCase eliminarLaboratorioUseCase,
                                 ActualizarLaboratorioUseCase actualizarLaboratorioUseCase,
                                 LaboratorioMapper laboratorioMapper) {
        this.crearLaboratorioUseCase = crearLaboratorioUseCase;
        this.listarLaboratoriosUseCase = listarLaboratoriosUseCase;
        this.obtenerLaboratorioUseCase = obtenerLaboratorioUseCase;
        this.eliminarLaboratorioUseCase = eliminarLaboratorioUseCase;
        this.actualizarLaboratorioUseCase = actualizarLaboratorioUseCase;
        this.laboratorioMapper = laboratorioMapper;
    }

    @GetMapping
    public ResponseEntity<List<LaboratorioResponse>> listar() {
        List<LaboratorioResponse> responses = listarLaboratoriosUseCase.listar().stream()
                .map(laboratorioMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioResponse> obtenerPorId(@PathVariable Integer id) {
        return obtenerLaboratorioUseCase.obtenerPorId(id)
                .map(laboratorio -> ResponseEntity.ok(laboratorioMapper.toResponse(laboratorio)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LaboratorioResponse> crear(@Valid @RequestBody LaboratorioRequest request) {
        var laboratorio = crearLaboratorioUseCase.crear(laboratorioMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(laboratorioMapper.toResponse(laboratorio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaboratorioResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody LaboratorioRequest request) {
        var laboratorio = actualizarLaboratorioUseCase.actualizar(id, laboratorioMapper.toDomain(request));
        return ResponseEntity.ok(laboratorioMapper.toResponse(laboratorio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        eliminarLaboratorioUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
