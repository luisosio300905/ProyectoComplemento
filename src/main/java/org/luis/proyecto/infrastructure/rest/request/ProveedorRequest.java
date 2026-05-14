package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProveedorRequest(
        @NotNull
        @NotBlank(message = "Debe ingresar un nombre")
        String nombre,
        @NotNull
        @NotBlank(message = "Debe ingresar una descripción")
        String descripcion,
        @NotNull
        @NotBlank(message = "Debe ingresar una razón social")
        String razonSocial,
        @NotNull(message = "Debe ingresar el ID del tipo de documento")
        Integer idTipoDocumento,
        @NotNull
        @NotBlank(message = "Debe ingresar el número de documento")
        String numeroDocumento,
        @NotNull
        @NotBlank(message = "Debe ingresar una dirección")
        String direccion,
        @NotNull
        @NotBlank(message = "Debe ingresar el celular")
        String celular,
        @NotNull
        @NotBlank(message = "Debe ingresar el correo")
        String correo
) {
}

