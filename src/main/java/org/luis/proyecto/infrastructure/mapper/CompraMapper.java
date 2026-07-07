package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Compra;
import org.luis.proyecto.infrastructure.persistence.entity.CompraEntity;
import org.luis.proyecto.infrastructure.persistence.entity.ComprobantePagoEntity;
import org.luis.proyecto.infrastructure.persistence.entity.ProveedorEntity;
import org.luis.proyecto.infrastructure.persistence.repository.JpaComprobantePagoRepository;
import org.luis.proyecto.infrastructure.persistence.repository.JpaProveedorRepository;
import org.luis.proyecto.infrastructure.rest.request.CompraRequest;
import org.luis.proyecto.infrastructure.rest.response.CompraResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraMapper {
    private final ProveedorMapper proveedorMapper;
    private final ComprobantePagoMapper comprobantePagoMapper;
    private final JpaProveedorRepository jpaProveedorRepository;
    private final JpaComprobantePagoRepository jpaComprobantePagoRepository;

    public CompraMapper(ProveedorMapper proveedorMapper,
                       ComprobantePagoMapper comprobantePagoMapper,
                       JpaProveedorRepository jpaProveedorRepository,
                       JpaComprobantePagoRepository jpaComprobantePagoRepository) {
        this.proveedorMapper = proveedorMapper;
        this.comprobantePagoMapper = comprobantePagoMapper;
        this.jpaProveedorRepository = jpaProveedorRepository;
        this.jpaComprobantePagoRepository = jpaComprobantePagoRepository;
    }

    public Compra toCompra(CompraEntity compraEntity) {
        if (compraEntity == null) {
            return null;
        }

        return new Compra(
                compraEntity.getId(),
                compraEntity.getFecha(),
                compraEntity.getTotal(),
                proveedorMapper.toProveedor(compraEntity.getProveedor()),
                comprobantePagoMapper.toDomain(compraEntity.getComprobantePago())
        );
    }

    public CompraEntity toCompraEntity(Compra compra) {
        if (compra == null) {
            return null;
        }

        return new CompraEntity(
                compra.getId(),
                compra.getFecha(),
                compra.getTotal(),
                proveedorMapper.toProveedorEntity(compra.getProveedor()),
                comprobantePagoMapper.toEntity(compra.getComprobantePago())
        );
    }

    public Compra toCompra(CompraRequest compraRequest) {
        if (compraRequest == null) {
            return null;
        }

        ProveedorEntity proveedorEntity = jpaProveedorRepository
                .findById(compraRequest.idProveedor())
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado"));

        ComprobantePagoEntity comprobantePagoEntity = jpaComprobantePagoRepository
                .findById(compraRequest.idComprobantePago())
                .orElseThrow(() -> new IllegalArgumentException("Comprobante de pago no encontrado"));

        return new Compra(
                compraRequest.fecha(),
                compraRequest.total(),
                proveedorMapper.toProveedor(proveedorEntity),
                comprobantePagoMapper.toDomain(comprobantePagoEntity)
        );
    }

    public List<Compra> toCompraList(List<CompraEntity> comprasEntities) {
        return comprasEntities
                .stream()
                .map(this::toCompra)
                .toList();
    }

    public CompraResponse toCompraResponse(Compra compra) {
        if (compra == null) {
            return null;
        }

        return new CompraResponse(
                compra.getId(),
                compra.getFecha(),
                compra.getTotal(),
                compra.getProveedor(),
                compra.getComprobantePago()
        );
    }

    public List<CompraResponse> toCompraResponseList(List<Compra> compras) {
        return compras
                .stream()
                .map(this::toCompraResponse)
                .toList();
    }
}
