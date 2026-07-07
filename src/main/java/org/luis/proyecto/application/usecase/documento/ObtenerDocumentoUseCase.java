package org.luis.proyecto.application.usecase.documento;

import org.luis.proyecto.domain.model.Documento;

public interface ObtenerDocumentoUseCase {
    Documento obtenerDocumento(String id);
}

