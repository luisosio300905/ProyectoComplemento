package org.luis.proyecto.application.service.diariodetalle.impl;

import org.luis.proyecto.application.service.diariodetalle.DiarioDetalleService;
import org.luis.proyecto.application.usecase.diariodetalle.*;
import org.luis.proyecto.domain.model.DiarioDetalle;

import java.util.List;

public class DiarioDetalleServiceImpl implements DiarioDetalleService {
    private final CrearDiarioDetalleUseCase crearDiarioDetalleUseCase;
    private final ActualizarDiarioDetalleUseCase actualizarDiarioDetalleUseCase;
    private final EliminarDiarioDetalleUseCase eliminarDiarioDetalleUseCase;
    private final ListaDiarioDetalleUseCase listaDiarioDetalleUseCase;
    private final ObtenerDiarioDetalleUseCase obtenerDiarioDetalleUseCase;

    public DiarioDetalleServiceImpl(CrearDiarioDetalleUseCase crearDiarioDetalleUseCase, ActualizarDiarioDetalleUseCase actualizarDiarioDetalleUseCase, EliminarDiarioDetalleUseCase eliminarDiarioDetalleUseCase, ListaDiarioDetalleUseCase listaDiarioDetalleUseCase, ObtenerDiarioDetalleUseCase obtenerDiarioDetalleUseCase) {
        this.crearDiarioDetalleUseCase = crearDiarioDetalleUseCase;
        this.actualizarDiarioDetalleUseCase = actualizarDiarioDetalleUseCase;
        this.eliminarDiarioDetalleUseCase = eliminarDiarioDetalleUseCase;
        this.listaDiarioDetalleUseCase = listaDiarioDetalleUseCase;
        this.obtenerDiarioDetalleUseCase = obtenerDiarioDetalleUseCase;
    }

    @Override
    public DiarioDetalle crear(DiarioDetalle diarioDetalle) {
        return crearDiarioDetalleUseCase.crear(diarioDetalle);
    }

    @Override
    public DiarioDetalle actualizar(Integer id, DiarioDetalle diarioDetalle) {
        return actualizarDiarioDetalleUseCase.actualizar(id, diarioDetalle);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarDiarioDetalleUseCase.eliminar(id);
    }

    @Override
    public void eliminarPorDiaCabCompId(Long diaCabCompId) {
        eliminarDiarioDetalleUseCase.eliminarPorDiaCabCompId(diaCabCompId);
    }

    @Override
    public DiarioDetalle obtenerById(Integer id) {
        return obtenerDiarioDetalleUseCase.obtenerById(id);
    }

    @Override
    public List<DiarioDetalle> obtenerTodos() {
        return listaDiarioDetalleUseCase.obtenerTodos();
    }

    @Override
    public List<DiarioDetalle> obtenerPorDiaCabCompId(Long diaCabCompId) {
        return listaDiarioDetalleUseCase.obtenerPorDiaCabCompId(diaCabCompId);
    }
}

