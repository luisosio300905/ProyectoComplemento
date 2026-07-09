package org.luis.proyecto.application.service.mapeocuentas;

import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.model.Venta;

import java.util.List;

public interface MapeoVentaCuentasService {
    List<DiarioDetalle> construirAsientoVenta(Venta venta, String usuario);
}
