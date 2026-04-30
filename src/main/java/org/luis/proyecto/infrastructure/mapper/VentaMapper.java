package org.luis.proyecto.infrastructure.mapper;


import java.util.List;

import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.infrastructure.persistence.entity.VentaEntity;
import org.luis.proyecto.infrastructure.rest.request.VentaRequest;
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
                VentaRequest.fecha(),
                VentaRequest.total());
    }

    public List<Venta> toVentaList(List<VentaEntity> ventaEntities) {
        return VentaEntities
                .stream()
                .map(p -> toventa(p))
                .toList();
    }

    public ventaResponse toventaResponse(venta venta) {
        return new ventaResponse(
                venta.getId(),
                venta.getNombre(),
                venta.getDescripcion(),
                venta.getCategoria(),
                venta.getPrecio(),
                venta.getStock()
        );
    }

    public List<ventaResponse> toventaResponseList(List<venta> ventas) {
        return ventas
                .stream()
                .map(p -> toventaResponse(p))
                .toList();
    }
}
