package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotNull;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.model.Venta;
import java.math.BigDecimal;

public record DetalleVentaRequest (
        @NotNull
        Venta venta,

        @NotNull
        Producto producto,

        @NotNull
        BigDecimal subTotal
){}