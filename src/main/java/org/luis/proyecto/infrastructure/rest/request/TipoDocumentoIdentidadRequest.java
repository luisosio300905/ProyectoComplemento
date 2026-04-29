package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TipoDocumentoIdentidadRequest(
        @NotNull
        @NotBlank(message = "Debe ingresar un nombre")
        String nombre
) {}
