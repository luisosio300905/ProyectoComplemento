package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.SubDivisionaria;
import org.luis.proyecto.infrastructure.persistence.entity.SubDivisionariaEntity;
import org.luis.proyecto.infrastructure.rest.request.SubDivisionariaRequest;
import org.luis.proyecto.infrastructure.rest.response.SubDivisionariaResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubDivisionariaMapper {
    public SubDivisionaria toSubDivisionaria(SubDivisionariaEntity entity) {
        SubDivisionaria subDivisionaria = new SubDivisionaria();
        subDivisionaria.setCuentaId(entity.getCuentaId());
        subDivisionaria.setSubCtaId(entity.getSubCtaId());
        subDivisionaria.setDivisioId(entity.getDivisioId());
        subDivisionaria.setSubDivId(entity.getSubDivId());
        subDivisionaria.setSubDivDescripcion(entity.getSubDivDescripcion());
        subDivisionaria.setSubDivCenCost(entity.getSubDivCenCost());
        subDivisionaria.setSubDivCtaCte(entity.getSubDivCtaCte());
        subDivisionaria.setSubDivAnalisis(entity.getSubDivAnalisis());
        subDivisionaria.setSubDivEstado(entity.getSubDivEstado());
        subDivisionaria.setTipCtaId(entity.getTipCtaId());
        subDivisionaria.setSubDivNumDigSunat(entity.getSubDivNumDigSunat());
        subDivisionaria.setUsrSistema(entity.getUsrSistema());
        subDivisionaria.setFecSistema(entity.getFecSistema());
        subDivisionaria.setHrsSistema(entity.getHrsSistema());
        subDivisionaria.setCta5(entity.getCta5());
        subDivisionaria.setCta8(entity.getCta8());
        return subDivisionaria;
    }

    public SubDivisionariaEntity toSubDivisionariaEntity(SubDivisionaria subDivisionaria) {
        SubDivisionariaEntity entity = new SubDivisionariaEntity();
        entity.setCuentaId(subDivisionaria.getCuentaId());
        entity.setSubCtaId(subDivisionaria.getSubCtaId());
        entity.setDivisioId(subDivisionaria.getDivisioId());
        entity.setSubDivId(subDivisionaria.getSubDivId());
        entity.setSubDivDescripcion(subDivisionaria.getSubDivDescripcion());
        entity.setSubDivCenCost(subDivisionaria.getSubDivCenCost());
        entity.setSubDivCtaCte(subDivisionaria.getSubDivCtaCte());
        entity.setSubDivAnalisis(subDivisionaria.getSubDivAnalisis());
        entity.setSubDivEstado(subDivisionaria.getSubDivEstado());
        entity.setTipCtaId(subDivisionaria.getTipCtaId());
        entity.setSubDivNumDigSunat(subDivisionaria.getSubDivNumDigSunat());
        entity.setUsrSistema(subDivisionaria.getUsrSistema());
        entity.setFecSistema(subDivisionaria.getFecSistema());
        entity.setHrsSistema(subDivisionaria.getHrsSistema());
        entity.setCta5(subDivisionaria.getCta5());
        entity.setCta8(subDivisionaria.getCta8());
        return entity;
    }

    public SubDivisionaria toSubDivisionaria(SubDivisionariaRequest request) {
        SubDivisionaria subDivisionaria = new SubDivisionaria();
        subDivisionaria.setCuentaId(request.cuentaId());
        subDivisionaria.setSubCtaId(request.subCtaId());
        subDivisionaria.setDivisioId(request.divisioId());
        subDivisionaria.setSubDivId(request.subDivId());
        subDivisionaria.setSubDivDescripcion(request.subDivDescripcion());
        subDivisionaria.setSubDivCenCost(request.subDivCenCost());
        subDivisionaria.setSubDivCtaCte(request.subDivCtaCte());
        subDivisionaria.setSubDivAnalisis(request.subDivAnalisis());
        subDivisionaria.setSubDivEstado(request.subDivEstado());
        subDivisionaria.setTipCtaId(request.tipCtaId());
        subDivisionaria.setSubDivNumDigSunat(request.subDivNumDigSunat());
        subDivisionaria.setUsrSistema(request.usrSistema());
        subDivisionaria.setFecSistema(request.fecSistema());
        subDivisionaria.setHrsSistema(request.hrsSistema());
        subDivisionaria.setCta5(request.cta5());
        subDivisionaria.setCta8(request.cta8());
        return subDivisionaria;
    }

    public List<SubDivisionaria> toSubDivisionariaList(List<SubDivisionariaEntity> entities) {
        return entities.stream().map(this::toSubDivisionaria).toList();
    }

    public SubDivisionariaResponse toSubDivisionariaResponse(SubDivisionaria subDivisionaria) {
        return new SubDivisionariaResponse(
                subDivisionaria.getCuentaId(),
                subDivisionaria.getSubCtaId(),
                subDivisionaria.getDivisioId(),
                subDivisionaria.getSubDivId(),
                subDivisionaria.getSubDivDescripcion(),
                subDivisionaria.getSubDivCenCost(),
                subDivisionaria.getSubDivCtaCte(),
                subDivisionaria.getSubDivAnalisis(),
                subDivisionaria.getSubDivEstado(),
                subDivisionaria.getTipCtaId(),
                subDivisionaria.getSubDivNumDigSunat(),
                subDivisionaria.getUsrSistema(),
                subDivisionaria.getFecSistema(),
                subDivisionaria.getHrsSistema(),
                subDivisionaria.getCta5(),
                subDivisionaria.getCta8()
        );
    }

    public List<SubDivisionariaResponse> toSubDivisionariaResponseList(List<SubDivisionaria> subDivisionarias) {
        return subDivisionarias.stream().map(this::toSubDivisionariaResponse).toList();
    }
}

