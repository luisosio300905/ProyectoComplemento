package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.compra.CompraService;
import org.luis.proyecto.infrastructure.mapper.CompraMapper;
import org.luis.proyecto.infrastructure.rest.request.CompraRequest;
import org.luis.proyecto.infrastructure.rest.response.CompraResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    private final CompraService compraService;
    private final CompraMapper compraMapper;

    public CompraController(CompraService compraService, CompraMapper compraMapper) {
        this.compraService = compraService;
        this.compraMapper = compraMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<CompraResponse>> getCompras() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(compraMapper.toCompraResponseList(compraService.obtenerTodas()));
    }

    @PostMapping("")
    public ResponseEntity<CompraResponse> createCompra(@RequestBody CompraRequest compraRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(compraMapper.toCompraResponse(
                        compraService.crear(compraMapper.toCompra(compraRequest))
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraResponse> getCompra(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(compraMapper.toCompraResponse(
                        compraService.obtenerCompra(id)
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraResponse> updateCompra(@PathVariable Integer id,
                                                       @RequestBody CompraRequest compraRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(compraMapper.toCompraResponse(
                        compraService.actualizar(id, compraMapper.toCompra(compraRequest))
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Integer id) {
        compraService.eliminar(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}

