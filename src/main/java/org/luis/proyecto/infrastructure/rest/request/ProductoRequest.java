package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record ProductoRequest(
        @NotNull
        @NotBlank(message = "Debe ingresar un nombre")
        String nombre,
        @NotNull
        @NotBlank(message = "Debe ingresar un codigo")
        String codigo,
        @NotNull
        @NotBlank(message = "Debe ingresar una descripcion")
        String descripcion,
        @NotNull
        @NotBlank(message = "Debe ingresar una categoria")
        String categoria,
        @Size(min = 0, message = "Debe ingresar un precio positivo")
        BigDecimal precio,
        @NotNull
        @Size(min = 0, message = "Debe ingresar un stock positivo")
        int stock
) {}
