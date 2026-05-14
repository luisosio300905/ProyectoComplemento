package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.proveedor.ProveedorService;
import org.luis.proyecto.infrastructure.mapper.ProveedorMapper;
import org.luis.proyecto.infrastructure.rest.request.ProveedorRequest;
import org.luis.proyecto.infrastructure.rest.response.ProveedorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    private final ProveedorService proveedorService;
    private final ProveedorMapper proveedorMapper;

    public ProveedorController(ProveedorService proveedorService, ProveedorMapper proveedorMapper) {
        this.proveedorService = proveedorService;
        this.proveedorMapper = proveedorMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ProveedorResponse>> getProveedores() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(proveedorMapper.toProveedorResponseList(proveedorService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<ProveedorResponse> createProveedor(@RequestBody ProveedorRequest proveedorRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(proveedorMapper.toProveedorResponse(
                        proveedorService.crear(
                                proveedorMapper.toProveedor(proveedorRequest)
                        )
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponse> getProveedor(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(proveedorMapper.toProveedorResponse(
                        proveedorService.obtenerProveedor(id)
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponse> updateProveedor(@PathVariable Integer id,
                                                             @RequestBody ProveedorRequest proveedorRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(proveedorMapper.toProveedorResponse(
                        proveedorService.actualizar(id, proveedorMapper.toProveedor(proveedorRequest))
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Integer id) {
        proveedorService.eliminar(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}

