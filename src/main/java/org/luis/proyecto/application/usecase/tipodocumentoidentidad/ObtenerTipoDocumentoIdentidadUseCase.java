package org.luis.proyecto.application.usecase.tipodocumentoidentidad;

import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;

public interface ObtenerTipoDocumentoIdentidadUseCase {
    TipoDocumentoIdentidad obtenerTipoDocumentoIdentidad(Integer id);
}
