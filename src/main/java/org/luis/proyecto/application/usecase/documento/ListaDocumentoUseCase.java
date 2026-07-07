package org.luis.proyecto.application.usecase.documento;

import org.luis.proyecto.domain.model.Documento;

import java.util.List;

public interface ListaDocumentoUseCase {
    List<Documento> obtenerTodos();
}

