package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Moneda;
import org.luis.proyecto.infrastructure.persistence.entity.MonedaEntity;
import org.luis.proyecto.infrastructure.rest.request.MonedaRequest;
import org.luis.proyecto.infrastructure.rest.response.MonedaResponse;
import org.springframework.stereotype.Component;

@Component
public class MonedaMapper {

    public Moneda toDomain(MonedaEntity entity) {
        if (entity == null) return null;
        Moneda domain = new Moneda();
        domain.setId(entity.getId());
        domain.setMonedaDescripcion(entity.getMonedaDescripcion());
        domain.setMonedaAbrev(entity.getMonedaAbrev());
        domain.setMonedaEst(entity.getMonedaEst());
        domain.setMonedaAbrevSunat(entity.getMonedaAbrevSunat());
        domain.setUsrSistema(entity.getUsrSistema());
        domain.setFecSistema(entity.getFecSistema());
        domain.setHrsSistema(entity.getHrsSistema());
        return domain;
    }

    public MonedaEntity toEntity(Moneda domain) {
        if (domain == null) return null;
        MonedaEntity entity = new MonedaEntity();
        if (domain.getId() != null) {
            entity.setId(domain.getId());
        }
        entity.setMonedaDescripcion(domain.getMonedaDescripcion());
        entity.setMonedaAbrev(domain.getMonedaAbrev());
        entity.setMonedaEst(domain.getMonedaEst());
        entity.setMonedaAbrevSunat(domain.getMonedaAbrevSunat());
        entity.setUsrSistema(domain.getUsrSistema());
        entity.setFecSistema(domain.getFecSistema());
        entity.setHrsSistema(domain.getHrsSistema());
        return entity;
    }

    public Moneda toDomain(MonedaRequest request) {
        if (request == null) return null;
        Moneda domain = new Moneda();
        domain.setMonedaDescripcion(request.monedaDescripcion());
        domain.setMonedaAbrev(request.monedaAbrev());
        domain.setMonedaEst(request.monedaEst());
        domain.setMonedaAbrevSunat(request.monedaAbrevSunat());
        domain.setUsrSistema(request.usrSistema());
        domain.setFecSistema(request.fecSistema());
        domain.setHrsSistema(request.hrsSistema());
        return domain;
    }

    public MonedaResponse toResponse(Moneda domain) {
        if (domain == null) {
            return null;
        }

        return new MonedaResponse(
                domain.getId(),
                domain.getMonedaDescripcion(),
                domain.getMonedaAbrev(),
                domain.getMonedaEst(),
                domain.getMonedaAbrevSunat(),
                domain.getUsrSistema(),
                domain.getFecSistema(),
                domain.getHrsSistema()
        );
    }
}
