package org.luis.proyecto.application.service.tipodocumentoidentidad;

import org.luis.proyecto.infrastructure.rest.request.TipoDocumentoIdentidadRequest;
import org.luis.proyecto.infrastructure.rest.response.TipoDocumentoIdentidadResponse;

import java.util.List;

public interface TipoDocumentoIdentidadService {
    TipoDocumentoIdentidadResponse crear(TipoDocumentoIdentidadRequest tipodocumentoidentidad);
    TipoDocumentoIdentidadResponse actualizar(Integer id, TipoDocumentoIdentidadRequest tipodocumentoidentidad);
    TipoDocumentoIdentidadResponse actualizar(String nombre, TipoDocumentoIdentidadRequest tipodocumentoidentidad);
    void eliminar(Integer id);
    TipoDocumentoIdentidadResponse obtenerTipoDocumentoIdentidad(Integer id);
    List<TipoDocumentoIdentidadResponse> obtenerTodos();
}
