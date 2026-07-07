package org.luis.proyecto.application.service.documento.impl;

import org.luis.proyecto.application.service.documento.DocumentoService;
import org.luis.proyecto.application.usecase.documento.*;
import org.luis.proyecto.domain.model.Documento;

import java.util.List;

public class DocumentoServiceImpl implements DocumentoService {
    private final ActualizarDocumentoUseCase actualizarDocumentoUseCase;
    private final CrearDocumentoUseCase crearDocumentoUseCase;
    private final EliminarDocumentoUseCase eliminarDocumentoUseCase;
    private final ListaDocumentoUseCase listaDocumentoUseCase;
    private final ObtenerDocumentoUseCase obtenerDocumentoUseCase;

    public DocumentoServiceImpl(ActualizarDocumentoUseCase actualizarDocumentoUseCase, CrearDocumentoUseCase crearDocumentoUseCase, EliminarDocumentoUseCase eliminarDocumentoUseCase, ListaDocumentoUseCase listaDocumentoUseCase, ObtenerDocumentoUseCase obtenerDocumentoUseCase) {
        this.actualizarDocumentoUseCase = actualizarDocumentoUseCase;
        this.crearDocumentoUseCase = crearDocumentoUseCase;
        this.eliminarDocumentoUseCase = eliminarDocumentoUseCase;
        this.listaDocumentoUseCase = listaDocumentoUseCase;
        this.obtenerDocumentoUseCase = obtenerDocumentoUseCase;
    }

    @Override
    public Documento crear(Documento documento) {
        return crearDocumentoUseCase.crear(documento);
    }

    @Override
    public Documento actualizar(String id, Documento documento) {
        return actualizarDocumentoUseCase.actualizar(id, documento);
    }

    @Override
    public void eliminar(String id) {
        eliminarDocumentoUseCase.eliminar(id);
    }

    @Override
    public Documento obtenerDocumento(String id) {
        return obtenerDocumentoUseCase.obtenerDocumento(id);
    }

    @Override
    public List<Documento> obtenerTodos() {
        return listaDocumentoUseCase.obtenerTodos();
    }
}

