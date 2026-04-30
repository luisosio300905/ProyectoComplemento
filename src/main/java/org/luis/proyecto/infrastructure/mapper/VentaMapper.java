package org.luis.proyecto.infrastructure.mapper;


import java.util.List;

import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.infrastructure.persistence.entity.VentaEntity;
import org.luis.proyecto.infrastructure.rest.request.VentaRequest;
import org.luis.proyecto.infrastructure.rest.response.VentaResponse;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {
    public Venta toVenta(VentaEntity ventaEntity) {
        return new Venta(
                ventaEntity.getId(),
                ventaEntity.getFecha(),
                ventaEntity.getTotal()
        );
    }

    public VentaEntity toVentaEntity(Venta venta) {
        return new VentaEntity(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal()
        );
    }

    public Venta toVenta(VentaRequest ventaRequest) {
        return new Venta(
            ventaRequest.id(),
                ventaRequest.fecha(),
                ventaRequest.total()
            );
    }

    public List<Venta> toVentaList(List<VentaEntity> ventaEntities) {
        return ventaEntities
                .stream()
                .map(p -> toVenta(p))
                .toList();
    }

    public VentaResponse toVentaResponse(Venta venta) {
        return new VentaResponse(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal()
        );
    }

    public List<VentaResponse> toVentaResponseList(List<Venta> venta) {
        return venta
                .stream()
                .map(p -> toVentaResponse(p))
                .toList();
    }
}
