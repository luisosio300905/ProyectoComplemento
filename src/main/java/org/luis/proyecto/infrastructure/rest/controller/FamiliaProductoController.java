package org.luis.proyecto.infrastructure.rest.controller;

import jakarta.validation.Valid;
import org.luis.proyecto.application.usecase.familiaproducto.*;
import org.luis.proyecto.infrastructure.mapper.FamiliaProductoMapper;
import org.luis.proyecto.infrastructure.rest.request.FamiliaProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.FamiliaProductoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/familias-producto")
public class FamiliaProductoController {
    private final CrearFamiliaProductoUseCase crearFamiliaProductoUseCase;
    private final ListarFamiliasProductoUseCase listarFamiliasProductoUseCase;
    private final ObtenerFamiliaProductoUseCase obtenerFamiliaProductoUseCase;
    private final EliminarFamiliaProductoUseCase eliminarFamiliaProductoUseCase;
    private final ActualizarFamiliaProductoUseCase actualizarFamiliaProductoUseCase;
    private final FamiliaProductoMapper familiaProductoMapper;

    public FamiliaProductoController(CrearFamiliaProductoUseCase crearFamiliaProductoUseCase,
                                     ListarFamiliasProductoUseCase listarFamiliasProductoUseCase,
                                     ObtenerFamiliaProductoUseCase obtenerFamiliaProductoUseCase,
                                     EliminarFamiliaProductoUseCase eliminarFamiliaProductoUseCase,
                                     ActualizarFamiliaProductoUseCase actualizarFamiliaProductoUseCase,
                                     FamiliaProductoMapper familiaProductoMapper) {
        this.crearFamiliaProductoUseCase = crearFamiliaProductoUseCase;
        this.listarFamiliasProductoUseCase = listarFamiliasProductoUseCase;
        this.obtenerFamiliaProductoUseCase = obtenerFamiliaProductoUseCase;
        this.eliminarFamiliaProductoUseCase = eliminarFamiliaProductoUseCase;
        this.actualizarFamiliaProductoUseCase = actualizarFamiliaProductoUseCase;
        this.familiaProductoMapper = familiaProductoMapper;
    }

    @GetMapping
    public ResponseEntity<List<FamiliaProductoResponse>> listar() {
        List<FamiliaProductoResponse> responses = listarFamiliasProductoUseCase.listar().stream()
                .map(familiaProductoMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliaProductoResponse> obtenerPorId(@PathVariable Integer id) {
        return obtenerFamiliaProductoUseCase.obtenerPorId(id)
                .map(familiaProducto -> ResponseEntity.ok(familiaProductoMapper.toResponse(familiaProducto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FamiliaProductoResponse> crear(@Valid @RequestBody FamiliaProductoRequest request) {
        var familiaProducto = crearFamiliaProductoUseCase.crear(familiaProductoMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaProductoMapper.toResponse(familiaProducto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliaProductoResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody FamiliaProductoRequest request) {
        var familiaProducto = actualizarFamiliaProductoUseCase.actualizar(id, familiaProductoMapper.toDomain(request));
        return ResponseEntity.ok(familiaProductoMapper.toResponse(familiaProducto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        eliminarFamiliaProductoUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
