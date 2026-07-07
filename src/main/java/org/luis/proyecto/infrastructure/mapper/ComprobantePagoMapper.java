package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.infrastructure.persistence.entity.ComprobantePagoEntity;
import org.luis.proyecto.infrastructure.rest.request.ComprobantePagoRequest;
import org.luis.proyecto.infrastructure.rest.response.ComprobantePagoResponse;
import org.springframework.stereotype.Component;

@Component
public class ComprobantePagoMapper {

    public ComprobantePagoEntity toEntity(ComprobantePago domain) {
        if (domain == null) return null;
        ComprobantePagoEntity entity = new ComprobantePagoEntity();
        entity.setId(domain.getId());
        entity.setComPagDescripcion(domain.getComPagDescripcion());
        entity.setUsrSistema(domain.getUsrSistema());
        entity.setFecSistema(domain.getFecSistema());
        entity.setHrsSistema(domain.getHrsSistema());
        return entity;
    }

    public ComprobantePago toDomain(ComprobantePagoEntity entity) {
        if (entity == null) return null;
        ComprobantePago domain = new ComprobantePago();
        domain.setId(entity.getId());
        domain.setComPagDescripcion(entity.getComPagDescripcion());
        domain.setUsrSistema(entity.getUsrSistema());
        domain.setFecSistema(entity.getFecSistema());
        domain.setHrsSistema(entity.getHrsSistema());
        return domain;
    }

    public ComprobantePago toDomain(ComprobantePagoRequest request) {
        if (request == null) return null;
        ComprobantePago domain = new ComprobantePago();
        domain.setId(request.id());
        domain.setComPagDescripcion(request.comPagDescripcion());
        domain.setUsrSistema(request.usrSistema());
        domain.setFecSistema(request.fecSistema());
        domain.setHrsSistema(request.hrsSistema());
        return domain;
    }

    public ComprobantePagoResponse toResponse(ComprobantePago domain) {
        if (domain == null) return null;
        return new ComprobantePagoResponse(
            domain.getId(),
            domain.getComPagDescripcion(),
            domain.getUsrSistema(),
            domain.getFecSistema(),
            domain.getHrsSistema()
        );
    }
}
