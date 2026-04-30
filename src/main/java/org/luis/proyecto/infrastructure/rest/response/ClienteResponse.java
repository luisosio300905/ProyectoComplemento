package org.luis.proyecto.infrastructure.rest.response;

import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;

public record ClienteResponse(
        Integer id,
        String descripcion,
        String razonSocial,
        String nombres,
        String apellidoPaterno,
        String apellidoMaterno,
        TipoDocumentoIdentidad tipoDocumentoIdentidad,
        String numeroDocumento,
        String direccion,
        String celular,
        String correo
) {
}
