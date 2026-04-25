package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(
        @NotNull
        @NotBlank(message = "Debe ingresar un nombre")
        String nombre,
        @NotNull
        @NotBlank(message = "Debe ingresar una contraseña")
        String contrasenia
) {}

