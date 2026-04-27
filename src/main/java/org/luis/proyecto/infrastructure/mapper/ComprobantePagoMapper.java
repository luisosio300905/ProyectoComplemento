package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.infrastructure.persistence.entity.ComprobantePagoEntity;
import org.luis.proyecto.infrastructure.rest.request.ComprobantePagoRequest;
import org.luis.proyecto.infrastructure.rest.response.ComprobantePagoResponse;
import org.luis.proyecto.infrastructure.rest.response.ProductoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComprobantePagoMapper {

    public ComprobantePago toComprobantePago(ComprobantePagoEntity entity) {
        return new ComprobantePago(
                entity.getId(),
                entity.getCliente(), //usar mapper de cliente
                entity.getTotal(),
                entity.getTipoComprobantePago(), //usar mapper de tipocomprobantepago
                entity.getDescripcion()
        );
    }

    public ComprobantePagoEntity toComprobantePagoEntity(ComprobantePago comprobantePago){
        return new ComprobantePagoEntity(
                comprobantePago.getId(),
                comprobantePago.getCliente(), //usar mapper de cliente
                comprobantePago.getTotal(),
                comprobantePago.getTipoComprobantePago(), //usar mapper de tipocomprobantepago
                comprobantePago.getDescripcion()
        );
    }

    public ComprobantePago toComprobantePago(ComprobantePagoRequest comprobantePagoRequest){
        return new ComprobantePago(
                comprobantePagoRequest.cliente(),
                comprobantePagoRequest.total(),
                comprobantePagoRequest.tipoComprobantePago(),
                comprobantePagoRequest.descripcion()
        );
    }

    public List<ComprobantePago> toComprobantePagoList(List<ComprobantePagoEntity> entities) {
        return entities
                .stream()
                .map(this::toComprobantePago)
                .toList();
    }

    public ComprobantePagoResponse toComprobantePagoResponse(ComprobantePago comprobantePago) {
        return new ComprobantePagoResponse(
                comprobantePago.getCliente(),
                comprobantePago.getTotal(),
                comprobantePago.getTipoComprobantePago(),
                comprobantePago.getDescripcion()
        );
    }

    public List<ComprobantePagoResponse> toComprobantePagoResponseList(List<ComprobantePago> comprobantePagos) {
        return comprobantePagos
                .stream()
                .map(this::toComprobantePagoResponse)
                .toList();
    }
}
