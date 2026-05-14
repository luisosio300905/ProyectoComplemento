package org.luis.proyecto.infrastructure.mapper;


import java.util.List;

import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.infrastructure.persistence.entity.ComprobantePagoEntity;
import org.luis.proyecto.infrastructure.persistence.entity.VentaEntity;
import org.luis.proyecto.infrastructure.persistence.repository.JpaComprobantePagoRepository;
import org.luis.proyecto.infrastructure.rest.request.VentaRequest;
import org.luis.proyecto.infrastructure.rest.response.VentaResponse;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {
    private final ComprobantePagoMapper comprobantePagoMapper;
    private final JpaComprobantePagoRepository jpaComprobantePagoRepository;

    public VentaMapper(ComprobantePagoMapper comprobantePagoMapper,
                      JpaComprobantePagoRepository jpaComprobantePagoRepository) {
        this.comprobantePagoMapper = comprobantePagoMapper;
        this.jpaComprobantePagoRepository = jpaComprobantePagoRepository;
    }

    public Venta toVenta(VentaEntity ventaEntity) {
        if (ventaEntity == null) {
            return null;
        }
        return new Venta(
                ventaEntity.getId(),
                ventaEntity.getFecha(),
                ventaEntity.getTotal(),
                comprobantePagoMapper.toComprobantePago(ventaEntity.getComprobantePago())
        );
    }

    public VentaEntity toVentaEntity(Venta venta) {
        if (venta == null) {
            return null;
        }
        return new VentaEntity(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal(),
                comprobantePagoMapper.toComprobantePagoEntity(venta.getComprobantePago())
        );
    }

    public Venta toVenta(VentaRequest ventaRequest) {
        if (ventaRequest == null) {
            return null;
        }

        ComprobantePagoEntity comprobantePagoEntity = jpaComprobantePagoRepository
                .findById(ventaRequest.idComprobantePago())
                .orElseThrow(() -> new IllegalArgumentException("Comprobante de pago no encontrado"));

        return new Venta(
                ventaRequest.fecha(),
                ventaRequest.total(),
                comprobantePagoMapper.toComprobantePago(comprobantePagoEntity)
            );
    }

    public List<Venta> toVentaList(List<VentaEntity> ventaEntities) {
        return ventaEntities
                .stream()
                .map(this::toVenta)
                .toList();
    }

    public VentaResponse toVentaResponse(Venta venta) {
        if (venta == null) {
            return null;
        }
        return new VentaResponse(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal(),
                venta.getComprobantePago()
        );
    }

    public List<VentaResponse> toVentaResponseList(List<Venta> venta) {
        return venta
                .stream()
                .map(this::toVentaResponse)
                .toList();
    }
}
