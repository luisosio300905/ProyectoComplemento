package org.luis.proyecto.application.usecase.documento;

import org.luis.proyecto.domain.model.Documento;

public interface ActualizarDocumentoUseCase {
    Documento actualizar(String id, Documento documento);
}

