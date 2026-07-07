package org.luis.proyecto.application.service.documento;

import org.luis.proyecto.domain.model.Documento;

import java.util.List;

public interface DocumentoService {
    Documento crear(Documento documento);
    Documento actualizar(String id, Documento documento);
    void eliminar(String id);
    Documento obtenerDocumento(String id);
    List<Documento> obtenerTodos();
}

