package org.luis.proyecto.application.service.tipodocumentoidentidad.impl;

import org.luis.proyecto.application.service.tipodocumentoidentidad.TipoDocumentoIdentidadService;
import org.luis.proyecto.application.usecase.tipodocumentoidentidad.*;
import org.luis.proyecto.infrastructure.mapper.TipoDocumentoIdentidadMapper;
import org.luis.proyecto.infrastructure.rest.request.TipoDocumentoIdentidadRequest;
import org.luis.proyecto.infrastructure.rest.response.TipoDocumentoIdentidadResponse;

import java.util.List;

public class TipoDocumentoIdentidadServiceImpl implements TipoDocumentoIdentidadService {
    private final CrearTipoDocumentoIdentidadUseCase crearTipoDocumentoIdentidadUseCase;
    private final ActualizarTipoDocumentoIdentidadUseCase actualizarTipoDocumentoIdentidadUseCase;
    private final EliminarTipoDocumentoIdentidadUseCase eliminarTipoDocumentoIdentidadUseCase;
    private final ListaTipoDocumentoIdentidadsUseCase listaTipoDocumentoIdentidadUseCase;
    private final ObtenerTipoDocumentoIdentidadUseCase obtenerTipoDocumentoIdentidadUseCase;
    private final TipoDocumentoIdentidadMapper tipodocumentoidentidadMapper;

    public TipoDocumentoIdentidadServiceImpl(CrearTipoDocumentoIdentidadUseCase crearTipoDocumentoIdentidadUseCase, ActualizarTipoDocumentoIdentidadUseCase actualizarTipoDocumentoIdentidadUseCase, EliminarTipoDocumentoIdentidadUseCase eliminarTipoDocumentoIdentidadUseCase, ListaTipoDocumentoIdentidadsUseCase listaTipoDocumentoIdentidadUseCase, ObtenerTipoDocumentoIdentidadUseCase obtenerTipoDocumentoIdentidadUseCase, TipoDocumentoIdentidadMapper tipodocumentoidentidadMapper) {
        this.crearTipoDocumentoIdentidadUseCase = crearTipoDocumentoIdentidadUseCase;
        this.actualizarTipoDocumentoIdentidadUseCase = actualizarTipoDocumentoIdentidadUseCase;
        this.eliminarTipoDocumentoIdentidadUseCase = eliminarTipoDocumentoIdentidadUseCase;
        this.listaTipoDocumentoIdentidadUseCase = listaTipoDocumentoIdentidadUseCase;
        this.obtenerTipoDocumentoIdentidadUseCase = obtenerTipoDocumentoIdentidadUseCase;
        this.tipodocumentoidentidadMapper = tipodocumentoidentidadMapper;
    }


    public TipoDocumentoIdentidadResponse crear(TipoDocumentoIdentidadRequest tipodocumentoidentidad) {
        return tipodocumentoidentidadMapper.toTipoDocumentoIdentidadResponse(
                crearTipoDocumentoIdentidadUseCase.crear(tipodocumentoidentidadMapper.toTipoDocumentoIdentidad(tipodocumentoidentidad)));
    }

    public TipoDocumentoIdentidadResponse actualizar(Integer id, TipoDocumentoIdentidadRequest tipodocumentoidentidad) {
        return tipodocumentoidentidadMapper.toTipoDocumentoIdentidadResponse(
                actualizarTipoDocumentoIdentidadUseCase.actualizar(id, tipodocumentoidentidadMapper.toTipoDocumentoIdentidad(tipodocumentoidentidad)));
    }

    public TipoDocumentoIdentidadResponse actualizar(String nombre, TipoDocumentoIdentidadRequest tipodocumentoidentidad) {
        return tipodocumentoidentidadMapper.toTipoDocumentoIdentidadResponse(
                actualizarTipoDocumentoIdentidadUseCase.actualizar(nombre, tipodocumentoidentidadMapper.toTipoDocumentoIdentidad(tipodocumentoidentidad)));
    }

    @Override
    public void eliminar(Integer id) {
        eliminarTipoDocumentoIdentidadUseCase.eliminar(id);
    }

    @Override
    public TipoDocumentoIdentidadResponse obtenerTipoDocumentoIdentidad(Integer id) {
        return tipodocumentoidentidadMapper.toTipoDocumentoIdentidadResponse(obtenerTipoDocumentoIdentidadUseCase.obtenerTipoDocumentoIdentidad(id));
    }

    @Override
    public List<TipoDocumentoIdentidadResponse> obtenerTodos() {
        return tipodocumentoidentidadMapper.toTipoDocumentoIdentidadResponseList(listaTipoDocumentoIdentidadUseCase.obtenerTodos());
    }
}
