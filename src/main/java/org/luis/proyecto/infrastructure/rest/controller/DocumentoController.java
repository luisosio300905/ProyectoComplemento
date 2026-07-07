package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.application.service.documento.DocumentoService;
import org.luis.proyecto.infrastructure.mapper.DocumentoMapper;
import org.luis.proyecto.infrastructure.rest.request.DocumentoRequest;
import org.luis.proyecto.infrastructure.rest.response.DocumentoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {
    private final DocumentoService documentoService;
    private final DocumentoMapper documentoMapper;

    public DocumentoController(DocumentoService documentoService, DocumentoMapper documentoMapper) {
        this.documentoService = documentoService;
        this.documentoMapper = documentoMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<DocumentoResponse>> getDocumentos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(documentoService.obtenerTodos().stream()
                        .map(documentoMapper::toResponse)
                        .toList());
    }

    @PostMapping("")
    public ResponseEntity<DocumentoResponse> createDocumento(@RequestBody DocumentoRequest documentoRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(documentoMapper.toResponse(
                        documentoService.crear(documentoMapper.toDomain(documentoRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoResponse> getDocumento(@PathVariable String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(documentoMapper.toResponse(documentoService.obtenerDocumento(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoResponse> updateDocumento(@PathVariable String id, @RequestBody DocumentoRequest documentoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(documentoMapper.toResponse(
                        documentoService.actualizar(id, documentoMapper.toDomain(documentoRequest))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable String id) {
        documentoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

