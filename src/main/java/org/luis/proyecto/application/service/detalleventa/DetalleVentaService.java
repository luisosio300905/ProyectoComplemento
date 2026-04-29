package org.luis.proyecto.application.service.detalleventa;

import org.luis.proyecto.domain.model.DetalleVenta;

import java.util.List;

public interface DetalleVentaService {
    DetalleVenta crear(DetalleVenta detalleVenta);
    DetalleVenta actualizar(Integer id, DetalleVenta detalleVenta);
    void eliminar(Integer id);
    DetalleVenta obtenerDetalleVenta(Integer id);
    List<DetalleVenta> obtenerTodos();
}
