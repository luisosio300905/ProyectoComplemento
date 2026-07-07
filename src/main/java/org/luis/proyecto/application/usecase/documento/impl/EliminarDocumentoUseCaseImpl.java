package org.luis.proyecto.application.usecase.documento.impl;

import org.luis.proyecto.application.usecase.documento.EliminarDocumentoUseCase;
import org.luis.proyecto.domain.repository.DocumentoRepository;

public class EliminarDocumentoUseCaseImpl implements EliminarDocumentoUseCase {
    private final DocumentoRepository documentoRepository;

    public EliminarDocumentoUseCaseImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public void eliminar(String id) {
        documentoRepository.deleteById(id);
    }
}

