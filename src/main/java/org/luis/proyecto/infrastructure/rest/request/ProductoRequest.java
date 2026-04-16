package org.luis.proyecto.infrastructure.rest.request;

import java.math.BigDecimal;

public record ProductoRequest(
        String nombre,
        String codigo,
        String descripcion,
        String categoria,
        BigDecimal precio,
        int stock
) {}
