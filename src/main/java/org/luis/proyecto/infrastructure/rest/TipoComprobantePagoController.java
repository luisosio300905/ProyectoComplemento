package org.luis.proyecto.infrastructure.rest;

import org.luis.proyecto.application.service.tipocomprobantepago.TipoComprobantePagoService;
import org.luis.proyecto.infrastructure.mapper.TipoComprobantePagoMapper;
import org.luis.proyecto.infrastructure.rest.request.TipoComprobantePagoRequest;
import org.luis.proyecto.infrastructure.rest.response.TipoComprobantePagoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-comprobante")
public class TipoComprobantePagoController {
    private final TipoComprobantePagoService tipoComprobantePagoService;
    private final TipoComprobantePagoMapper tipoComprobantePagoMapper;

    public TipoComprobantePagoController(TipoComprobantePagoService tipoComprobantePagoService,
                                         TipoComprobantePagoMapper tipoComprobantePagoMapper) {
        this.tipoComprobantePagoService = tipoComprobantePagoService;
        this.tipoComprobantePagoMapper = tipoComprobantePagoMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<TipoComprobantePagoResponse>> getTiposComprobante() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoComprobantePagoMapper.toTipoComprobantePagoResponseList(
                        tipoComprobantePagoService.obtenerTodos()));
    }

    @PostMapping("")
    public ResponseEntity<TipoComprobantePagoResponse> createTipoComprobantePago(
            @RequestBody TipoComprobantePagoRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tipoComprobantePagoMapper.toTipoComprobantePagoResponse(
                        tipoComprobantePagoService.crear(
                                tipoComprobantePagoMapper.toTipoComprobantePago(request))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoComprobantePagoResponse> getTipoComprobantePago(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoComprobantePagoMapper.toTipoComprobantePagoResponse(
                        tipoComprobantePagoService.obtenerTipoComprobantePago(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoComprobantePagoResponse> updateTipoComprobantePago(
            @PathVariable Integer id, @RequestBody TipoComprobantePagoRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoComprobantePagoMapper.toTipoComprobantePagoResponse(
                        tipoComprobantePagoService.actualizar(id,
                                tipoComprobantePagoMapper.toTipoComprobantePago(request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoComprobantePago(@PathVariable Integer id) {
        tipoComprobantePagoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}