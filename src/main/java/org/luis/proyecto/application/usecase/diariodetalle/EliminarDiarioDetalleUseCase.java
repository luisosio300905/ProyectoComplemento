package org.luis.proyecto.application.usecase.diariodetalle;

public interface EliminarDiarioDetalleUseCase {
    void eliminar(Integer id);
    void eliminarPorDiaCabCompId(Long diaCabCompId);
}

