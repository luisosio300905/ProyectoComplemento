package org.luis.proyecto.domain.model;

import java.math.BigDecimal;

public class DetalleVenta {
    private Integer id;
    private Venta venta;
    private Producto producto;
    private int cantidad;
    private BigDecimal subTotal;
}
