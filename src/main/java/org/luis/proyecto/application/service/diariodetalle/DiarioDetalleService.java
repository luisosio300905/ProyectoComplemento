package org.luis.proyecto.application.service.diariodetalle;

import org.luis.proyecto.domain.model.DiarioDetalle;

import java.util.List;

public interface DiarioDetalleService {
    DiarioDetalle crear(DiarioDetalle diarioDetalle);
    DiarioDetalle actualizar(Integer id, DiarioDetalle diarioDetalle);
    void eliminar(Integer id);
    void eliminarPorDiaCabCompId(Long diaCabCompId);
    DiarioDetalle obtenerById(Integer id);
    List<DiarioDetalle> obtenerTodos();
    List<DiarioDetalle> obtenerPorDiaCabCompId(Long diaCabCompId);
}

