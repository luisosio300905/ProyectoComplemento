package org.luis.proyecto.infrastructure.rest.controller;
import jakarta.validation.Valid;
import org.luis.proyecto.application.usecase.producto.*;
import org.luis.proyecto.infrastructure.mapper.ProductoMapper;
import org.luis.proyecto.infrastructure.rest.request.ProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.ProductoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final CrearProductoUseCase crearProductoUseCase;
    private final ListarProductosUseCase listarProductosUseCase;
    private final ObtenerProductoUseCase obtenerProductoUseCase;
    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final ActualizarProductoUseCase actualizarProductoUseCase;
    private final ProductoMapper productoMapper;
    public ProductoController(CrearProductoUseCase crearProductoUseCase,
                              ListarProductosUseCase listarProductosUseCase,
                              ObtenerProductoUseCase obtenerProductoUseCase,
                              EliminarProductoUseCase eliminarProductoUseCase,
                              ActualizarProductoUseCase actualizarProductoUseCase,
                              ProductoMapper productoMapper) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.listarProductosUseCase = listarProductosUseCase;
        this.obtenerProductoUseCase = obtenerProductoUseCase;
        this.eliminarProductoUseCase = eliminarProductoUseCase;
        this.actualizarProductoUseCase = actualizarProductoUseCase;
        this.productoMapper = productoMapper;
    }
    @GetMapping
    public ResponseEntity<List<ProductoResponse>> listar() {
        List<ProductoResponse> responses = listarProductosUseCase.listar().stream()
            .map(productoMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> obtenerPorId(@PathVariable Integer id) {
        return obtenerProductoUseCase.obtenerPorId(id)
                .map(producto -> ResponseEntity.ok(productoMapper.toResponse(producto)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ProductoResponse> crear(@Valid @RequestBody ProductoRequest request) {
        var producto = crearProductoUseCase.crear(productoMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(productoMapper.toResponse(producto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody ProductoRequest request) {
        var producto = actualizarProductoUseCase.actualizar(id, productoMapper.toDomain(request));
        return ResponseEntity.ok(productoMapper.toResponse(producto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        eliminarProductoUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
