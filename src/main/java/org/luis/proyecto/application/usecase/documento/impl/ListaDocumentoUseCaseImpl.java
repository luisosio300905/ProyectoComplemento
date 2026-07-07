package org.luis.proyecto.application.usecase.documento.impl;

import org.luis.proyecto.application.usecase.documento.ListaDocumentoUseCase;
import org.luis.proyecto.domain.model.Documento;
import org.luis.proyecto.domain.repository.DocumentoRepository;

import java.util.List;

public class ListaDocumentoUseCaseImpl implements ListaDocumentoUseCase {
    private final DocumentoRepository documentoRepository;

    public ListaDocumentoUseCaseImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public List<Documento> obtenerTodos() {
        return documentoRepository.findAll();
    }
}

