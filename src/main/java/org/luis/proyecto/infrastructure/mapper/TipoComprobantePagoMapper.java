package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.TipoComprobantePago;
import org.luis.proyecto.infrastructure.persistence.entity.TipoComprobantePagoEntity;
import org.luis.proyecto.infrastructure.rest.request.TipoComprobantePagoRequest;
import org.luis.proyecto.infrastructure.rest.response.TipoComprobantePagoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoComprobantePagoMapper {

    public TipoComprobantePago toTipoComprobantePago(TipoComprobantePagoEntity entity) {
        return new TipoComprobantePago(
                entity.getId(),
                entity.getTipoComprobante()
        );
    }

    public TipoComprobantePagoEntity toTipoComprobantePagoEntity(TipoComprobantePago tipoComprobantePago) {
        return new TipoComprobantePagoEntity(
                tipoComprobantePago.getId(),
                tipoComprobantePago.getTipoComprobante(),
                null
        );
    }

    public TipoComprobantePago toTipoComprobantePago(TipoComprobantePagoRequest request) {
        return new TipoComprobantePago(
                request.tipoComprobante()
        );
    }

    public List<TipoComprobantePago> toTipoComprobantePagoList(List<TipoComprobantePagoEntity> entities) {
        return entities
                .stream()
                .map(e -> toTipoComprobantePago(e))
                .toList();
    }

    public TipoComprobantePagoResponse toTipoComprobantePagoResponse(TipoComprobantePago tipoComprobantePago) {
        return new TipoComprobantePagoResponse(
                tipoComprobantePago.getId(),
                tipoComprobantePago.getTipoComprobante()
        );
    }

    public List<TipoComprobantePagoResponse> toTipoComprobantePagoResponseList(List<TipoComprobantePago> tipos) {
        return tipos
                .stream()
                .map(t -> toTipoComprobantePagoResponse(t))
                .toList();
    }
}