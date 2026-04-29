package org.luis.proyecto.application.usecase.tipodocumentoidentidad;

import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;

public interface ActualizarTipoDocumentoIdentidadUseCase {
    TipoDocumentoIdentidad actualizar(Integer id, TipoDocumentoIdentidad tipodocumentoidentidad);
    TipoDocumentoIdentidad actualizar(String nombre, TipoDocumentoIdentidad tipodocumentoidentidad);
}
