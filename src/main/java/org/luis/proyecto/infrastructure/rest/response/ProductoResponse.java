package org.luis.proyecto.infrastructure.rest.response;

import java.math.BigDecimal;

public record ProductoResponse(
        Integer id,
        String nombre,
        String descripcion,
        String categoria,
        BigDecimal precio,
        int stock
) {}
