package org.luis.proyecto.infrastructure.rest;

import org.luis.proyecto.application.service.producto.ProductoService;
import org.luis.proyecto.infrastructure.rest.request.ProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.ProductoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductoResponse>> getProductos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productoService.obtenerTodos());
    }

    @PostMapping("/")
    public ResponseEntity<ProductoResponse> createProducto(@RequestBody ProductoRequest productoRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productoService.crear(productoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> updateProducto(@PathVariable Integer id, @RequestBody ProductoRequest productoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productoService.actualizar(id, productoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
