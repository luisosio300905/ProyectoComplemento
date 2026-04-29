package org.luis.proyecto.infrastructure.rest.response;

import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.model.Venta;
import java.math.BigDecimal;

public record DetalleVentaResponse(
        Venta venta,
        Producto producto,
        BigDecimal subTotal
){ }