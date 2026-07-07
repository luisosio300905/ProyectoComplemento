package org.luis.proyecto.application.usecase.documento.impl;

import org.luis.proyecto.application.usecase.documento.ActualizarDocumentoUseCase;
import org.luis.proyecto.domain.model.Documento;
import org.luis.proyecto.domain.repository.DocumentoRepository;

public class ActualizarDocumentoUseCaseImpl implements ActualizarDocumentoUseCase {
    private final DocumentoRepository documentoRepository;

    public ActualizarDocumentoUseCaseImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public Documento actualizar(String id, Documento documento) {
        Documento documentoActualizar = documentoRepository.findById(id).orElseThrow();
        actualizarDocumento(documentoActualizar, documento);
        return documentoRepository.save(documentoActualizar);
    }

    private void actualizarDocumento(Documento actualizar, Documento datos){
        actualizar.setDocDescripcion(datos.getDocDescripcion());
        actualizar.setDocDesCorta(datos.getDocDesCorta());
        actualizar.setDocAbrev(datos.getDocAbrev());
        actualizar.setDocEstado(datos.getDocEstado());
        actualizar.setDocNumDigSerie(datos.getDocNumDigSerie());
        actualizar.setDocNumDigNumero(datos.getDocNumDigNumero());
        actualizar.setDocAfaNumerico(datos.getDocAfaNumerico());
        actualizar.setUsrSistema(datos.getUsrSistema());
        actualizar.setFecSistema(datos.getFecSistema());
        actualizar.setHrsSistema(datos.getHrsSistema());
    }
}

