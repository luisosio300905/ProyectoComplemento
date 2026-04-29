package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.DetalleVenta;
import org.luis.proyecto.infrastructure.persistence.entity.DetalleVentaEntity;
import org.luis.proyecto.infrastructure.rest.request.DetalleVentaRequest;
import org.luis.proyecto.infrastructure.rest.response.DetalleVentaResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetalleVentaMapper {

    public DetalleVenta toDetalleVenta(DetalleVentaEntity entity) {
//        return new DetalleVenta(
//                entity.getId(),
//                entity.getVenta(),
//                entity.getProducto(),
//                entity.getSubTotal()
//        );
        return null;
    }

    public DetalleVentaEntity toDetalleVentaEntity(DetalleVenta detalleVenta){
//        return new DetalleVentaEntity(
//                detalleVenta.getId(),
//                detalleVenta.getVenta(), // usar mapper de venta
//                detalleVenta.getProducto(), // usar mapper de producto
//                detalleVenta.getSubTotal()
//        );
        return null;
    }

    public DetalleVenta toDetalleVenta(DetalleVentaRequest detalleVentaRequest){
        return new DetalleVenta(
                null,
                detalleVentaRequest.venta(),
                detalleVentaRequest.producto(),
                detalleVentaRequest.subTotal()
        );
    }

    public List<DetalleVenta> toDetalleVentaList(List<DetalleVentaEntity> entities) {
        return entities
                .stream()
                .map(this::toDetalleVenta)
                .toList();
    }

    public DetalleVentaResponse toDetalleVentaResponse(DetalleVenta detalleVenta) {
        return new DetalleVentaResponse(
                detalleVenta.getVenta(),
                detalleVenta.getProducto(),
                detalleVenta.getSubTotal()
        );
    }

    public List<DetalleVentaResponse> toDetalleVentaResponseList(List<DetalleVenta> detalleVentas) {
        return detalleVentas
                .stream()
                .map(this::toDetalleVentaResponse)
                .toList();
    }
}