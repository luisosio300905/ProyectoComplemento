package org.luis.proyecto.infrastructure.rest.response;

import java.math.BigDecimal;

public record ProductoResponse(
        String nombre,
        String descripcion,
        String categoria,
        BigDecimal precio
) {}
