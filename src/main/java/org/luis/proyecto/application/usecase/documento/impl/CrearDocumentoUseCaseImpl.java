package org.luis.proyecto.application.usecase.documento.impl;

import org.luis.proyecto.application.usecase.documento.CrearDocumentoUseCase;
import org.luis.proyecto.domain.model.Documento;
import org.luis.proyecto.domain.repository.DocumentoRepository;

public class CrearDocumentoUseCaseImpl implements CrearDocumentoUseCase {
    private final DocumentoRepository documentoRepository;

    public CrearDocumentoUseCaseImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public Documento crear(Documento documento) {
        return documentoRepository.save(documento);
    }
}

