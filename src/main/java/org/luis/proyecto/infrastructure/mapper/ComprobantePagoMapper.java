package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.infrastructure.persistence.entity.ClienteEntity;
import org.luis.proyecto.infrastructure.persistence.entity.ComprobantePagoEntity;
import org.luis.proyecto.infrastructure.persistence.entity.TipoComprobantePagoEntity;
import org.luis.proyecto.infrastructure.persistence.repository.JpaClienteRepository;
import org.luis.proyecto.infrastructure.persistence.repository.JpaTipoComprobantePagoRepository;
import org.luis.proyecto.infrastructure.rest.request.ComprobantePagoRequest;
import org.luis.proyecto.infrastructure.rest.response.ComprobantePagoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComprobantePagoMapper {
    private final ClienteMapper clienteMapper;
    private final TipoComprobantePagoMapper tipoComprobantePagoMapper;
    private final JpaClienteRepository jpaClienteRepository;
    private final JpaTipoComprobantePagoRepository jpaTipoComprobantePagoRepository;

    public ComprobantePagoMapper(ClienteMapper clienteMapper,
                                TipoComprobantePagoMapper tipoComprobantePagoMapper,
                                JpaClienteRepository jpaClienteRepository,
                                JpaTipoComprobantePagoRepository jpaTipoComprobantePagoRepository) {
        this.clienteMapper = clienteMapper;
        this.tipoComprobantePagoMapper = tipoComprobantePagoMapper;
        this.jpaClienteRepository = jpaClienteRepository;
        this.jpaTipoComprobantePagoRepository = jpaTipoComprobantePagoRepository;
    }

    public ComprobantePago toComprobantePago(ComprobantePagoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ComprobantePago(
                entity.getId(),
                clienteMapper.toCliente(entity.getCliente()),
                entity.getTotal(),
                tipoComprobantePagoMapper.toTipoComprobantePago(entity.getTipoComprobantePago()),
                entity.getDescripcion()
        );
    }

    public ComprobantePagoEntity toComprobantePagoEntity(ComprobantePago comprobantePago) {
        if (comprobantePago == null) {
            return null;
        }
        return new ComprobantePagoEntity(
                comprobantePago.getId(),
                clienteMapper.toClienteEntity(comprobantePago.getCliente()),
                comprobantePago.getTotal(),
                tipoComprobantePagoMapper.toTipoComprobantePagoEntity(comprobantePago.getTipoComprobantePago()),
                comprobantePago.getDescripcion()
        );
    }

    public ComprobantePago toComprobantePago(ComprobantePagoRequest comprobantePagoRequest) {
        if (comprobantePagoRequest == null) {
            return null;
        }

        ClienteEntity clienteEntity = jpaClienteRepository
                .findById(comprobantePagoRequest.idCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        TipoComprobantePagoEntity tipoComprobantePagoEntity = jpaTipoComprobantePagoRepository
                .findById(comprobantePagoRequest.idTipoComprobante())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de comprobante no encontrado"));

        return new ComprobantePago(
                clienteMapper.toCliente(clienteEntity),
                comprobantePagoRequest.total(),
                tipoComprobantePagoMapper.toTipoComprobantePago(tipoComprobantePagoEntity),
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
        if (comprobantePago == null) {
            return null;
        }
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
