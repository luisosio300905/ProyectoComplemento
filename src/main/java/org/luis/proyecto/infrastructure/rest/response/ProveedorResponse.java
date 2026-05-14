package org.luis.proyecto.infrastructure.rest.response;

import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;

import java.time.LocalDateTime;

public record ProveedorResponse(
        Integer id,
        String nombre,
        String descripcion,
        String razonSocial,
        TipoDocumentoIdentidad tipoDocumentoIdentidad,
        String numeroDocumento,
        String direccion,
        String celular,
        String correo,
        LocalDateTime fechaIngreso,
        String estado
) {
}

