package org.luis.proyecto.application.service.venta;

import java.util.List;

import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.infrastructure.rest.response.VentaConBalanceResponse;

public interface VentaService {
    Venta crear(Venta venta);

    /**
     * Crea una venta y devuelve la información completa incluyendo el balance general
     * del asiento contable generado automáticamente.
     * @param venta Datos de la venta a crear
     * @return VentaConBalanceResponse con información de venta y balance del asiento
     */
    VentaConBalanceResponse crearConBalance(Venta venta);

    Venta actualizar(Integer id, Venta venta);
    void eliminar(Integer id);
    Venta obtenerVenta(Integer id);
    List<Venta> obtenerTodos();
}
