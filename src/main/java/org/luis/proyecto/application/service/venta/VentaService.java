package org.luis.proyecto.application.service.venta;

import java.util.List;

import org.luis.proyecto.domain.model.Venta;

public interface VentaService {
    Venta crear(Venta venta);
    Venta actualizar(Integer id, Venta venta);
    void eliminar(Integer id);
    Venta obtenerVenta(Integer id);
    List<Venta> obtenerTodos();
}
