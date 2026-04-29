package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.TipoDocumentoIdentidad;
import org.luis.proyecto.infrastructure.persistence.entity.TipoDocumentoIdentidadEntity;
import org.luis.proyecto.infrastructure.rest.request.TipoDocumentoIdentidadRequest;
import org.luis.proyecto.infrastructure.rest.response.TipoDocumentoIdentidadResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoDocumentoIdentidadMapper
{
    public TipoDocumentoIdentidad toTipoDocumentoIdentidad(TipoDocumentoIdentidadEntity tipodocumentoidentidadEntity) {
        return new TipoDocumentoIdentidad(
                tipodocumentoidentidadEntity.getId(),
                tipodocumentoidentidadEntity.getNombre()
        );
    }

    public TipoDocumentoIdentidadEntity toTipoDocumentoIdentidadEntity(TipoDocumentoIdentidad tipodocumentoidentidad) {
        return new TipoDocumentoIdentidadEntity(
                tipodocumentoidentidad.getId(),
                tipodocumentoidentidad.getNombre()
        );
    }

    public TipoDocumentoIdentidad toTipoDocumentoIdentidad(TipoDocumentoIdentidadRequest tipodocumentoidentidadRequest) {
        return new TipoDocumentoIdentidad(
                tipodocumentoidentidadRequest.nombre()
        );
    }

    public List<TipoDocumentoIdentidad> toTipoDocumentoIdentidadList(List<TipoDocumentoIdentidadEntity> tipodocumentoidentidadsEntities) {
        return tipodocumentoidentidadsEntities
                .stream()
                .map(p -> toTipoDocumentoIdentidad(p))
                .toList();
    }

    public TipoDocumentoIdentidadResponse toTipoDocumentoIdentidadResponse(TipoDocumentoIdentidad tipodocumentoidentidad) {
        return new TipoDocumentoIdentidadResponse(
                tipodocumentoidentidad.getNombre()
        );
    }

    public List<TipoDocumentoIdentidadResponse> toTipoDocumentoIdentidadResponseList(List<TipoDocumentoIdentidad> tipodocumentoidentidads) {
        return tipodocumentoidentidads
                .stream()
                .map(p -> toTipoDocumentoIdentidadResponse(p))
                .toList();
    }
}
