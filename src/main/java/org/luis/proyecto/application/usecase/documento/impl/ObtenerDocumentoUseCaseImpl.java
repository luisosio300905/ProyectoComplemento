package org.luis.proyecto.application.usecase.documento.impl;

import org.luis.proyecto.application.usecase.documento.ObtenerDocumentoUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Documento;
import org.luis.proyecto.domain.repository.DocumentoRepository;

public class ObtenerDocumentoUseCaseImpl implements ObtenerDocumentoUseCase {
    private final DocumentoRepository documentoRepository;

    public ObtenerDocumentoUseCaseImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public Documento obtenerDocumento(String id) {
        return documentoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento no encontrado"));
    }
}

