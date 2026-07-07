package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Laboratorio;
import org.luis.proyecto.infrastructure.persistence.entity.LaboratorioEntity;
import org.luis.proyecto.infrastructure.rest.request.LaboratorioRequest;
import org.luis.proyecto.infrastructure.rest.response.LaboratorioResponse;
import org.springframework.stereotype.Component;

@Component
public class LaboratorioMapper {

    public Laboratorio toDomain(LaboratorioEntity entity) {
        if (entity == null) return null;
        Laboratorio domain = new Laboratorio();
        domain.setId(entity.getId());
        domain.setLabDescripcion(entity.getLabDescripcion());
        domain.setLabEstado(entity.getLabEstado());
        domain.setCodlab(entity.getCodlab());
        domain.setUsrSistema(entity.getUsrSistema());
        domain.setFecSistema(entity.getFecSistema());
        domain.setHrsSistema(entity.getHrsSistema());
        return domain;
    }

    public LaboratorioEntity toEntity(Laboratorio domain) {
        if (domain == null) return null;
        LaboratorioEntity entity = new LaboratorioEntity();
        if (domain.getId() != null) {
            entity.setId(domain.getId());
        }
        entity.setLabDescripcion(domain.getLabDescripcion());
        entity.setLabEstado(domain.getLabEstado());
        entity.setCodlab(domain.getCodlab());
        entity.setUsrSistema(domain.getUsrSistema());
        entity.setFecSistema(domain.getFecSistema());
        entity.setHrsSistema(domain.getHrsSistema());
        return entity;
    }

    public Laboratorio toDomain(LaboratorioRequest request) {
        if (request == null) return null;
        Laboratorio domain = new Laboratorio();
        domain.setLabDescripcion(request.labDescripcion());
        domain.setLabEstado(request.labEstado());
        domain.setCodlab(request.codlab());
        domain.setUsrSistema(request.usrSistema());
        domain.setFecSistema(request.fecSistema());
        domain.setHrsSistema(request.hrsSistema());
        return domain;
    }

    public LaboratorioResponse toResponse(Laboratorio domain) {
        if (domain == null) {
            return null;
        }

        return new LaboratorioResponse(
                domain.getId(),
                domain.getLabDescripcion(),
                domain.getLabEstado(),
                domain.getCodlab(),
                domain.getUsrSistema(),
                domain.getFecSistema(),
                domain.getHrsSistema()
        );
    }
}
