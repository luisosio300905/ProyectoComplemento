package org.luis.proyecto.application.usecase.tipodocumentoidentidad;

import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;

import java.util.List;

public interface ListaTipoDocumentoIdentidadsUseCase {
    List<TipoDocumentoIdentidad> obtenerTodos();
}
