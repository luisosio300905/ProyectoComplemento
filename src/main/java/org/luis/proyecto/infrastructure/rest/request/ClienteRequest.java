package org.luis.proyecto.infrastructure.rest.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;

import java.math.BigDecimal;

public record ClienteRequest(
        @NotNull
        @NotBlank(message = "Debe ingresar una descripcion")
        String descripcion,
        @NotNull
        @NotBlank(message = "Debe ingresar una razon social")
        String razonSocial,
        @NotNull
        @NotBlank(message = "Debe ingresar los nombres")
        String nombres,
        @NotNull
        @NotBlank(message = "Debe ingresar el apellido paterno")
        String apellidoPaterno,
        @NotNull
        @NotBlank(message = "Debe ingresar el apellido materno")
        String apellidoMaterno,
        @NotNull(message = "Debe ingresar el tipo de documento")
        TipoDocumentoIdentidad tipoDocumentoIdentidad,
        @NotNull
        @NotBlank(message = "Debe ingresar la direccion")
        String numeroDocumento,
        @NotNull
        @NotBlank(message = "Debe ingresar una direccion")
        String direccion,
        @NotNull
        @NotBlank(message = "Debe ingresar el celular")
        @Size(min = 9, max = 9, message = "El celular debe tener 9 digitos")
        String celular,
        @NotNull
        @NotBlank(message = "Debe ingresar el correo")
        @Email(message = "Debe ingresar un correo valido")
        String correo


) {}
