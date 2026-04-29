package org.luis.proyecto.infrastructure.rest;
import org.luis.proyecto.application.service.tipodocumentoidentidad.TipoDocumentoIdentidadService;
import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;
import org.luis.proyecto.infrastructure.rest.request.TipoDocumentoIdentidadRequest;
import org.luis.proyecto.infrastructure.rest.response.TipoDocumentoIdentidadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tipodocumentoidentidad")
public class TipoDocumentoIdentidadController {
    private final TipoDocumentoIdentidadService tipodocumentoidentidadService;

    public TipoDocumentoIdentidadController(TipoDocumentoIdentidadService tipodocumentoidentidadService) {
        this.tipodocumentoidentidadService = tipodocumentoidentidadService;
    }

    @GetMapping("")
    public ResponseEntity<List<TipoDocumentoIdentidadResponse>> getTipoDocumentoIdentidads() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipodocumentoidentidadService.obtenerTodos());
    }

    @PostMapping("")
    public ResponseEntity<TipoDocumentoIdentidadResponse> createTipoDocumentoIdentidad(@RequestBody TipoDocumentoIdentidadRequest tipodocumentoidentidadRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tipodocumentoidentidadService.crear(tipodocumentoidentidadRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumentoIdentidadResponse> getTipoDocumentoIdentidad(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipodocumentoidentidadService.obtenerTipoDocumentoIdentidad(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumentoIdentidadResponse> updateTipoDocumentoIdentidad(@PathVariable Integer id, @RequestBody TipoDocumentoIdentidadRequest tipodocumentoidentidadRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipodocumentoidentidadService.actualizar(id, tipodocumentoidentidadRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDocumentoIdentidad(@PathVariable Integer id) {
        tipodocumentoidentidadService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
