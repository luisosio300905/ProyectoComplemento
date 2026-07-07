package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.FamiliaProducto;
import org.luis.proyecto.infrastructure.persistence.entity.FamiliaProductoEntity;
import org.luis.proyecto.infrastructure.rest.request.FamiliaProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.FamiliaProductoResponse;
import org.springframework.stereotype.Component;

@Component
public class FamiliaProductoMapper {

    public FamiliaProducto toDomain(FamiliaProductoEntity entity) {
        if (entity == null) return null;
        FamiliaProducto domain = new FamiliaProducto();
        domain.setId(entity.getId());
        domain.setFamDescripcion(entity.getFamDescripcion());
        domain.setFamEstado(entity.getFamEstado());
        domain.setCodfam(entity.getCodfam());
        domain.setUsrSistema(entity.getUsrSistema());
        domain.setFecSistema(entity.getFecSistema());
        domain.setHrsSistema(entity.getHrsSistema());
        return domain;
    }

    public FamiliaProductoEntity toEntity(FamiliaProducto domain) {
        if (domain == null) return null;
        FamiliaProductoEntity entity = new FamiliaProductoEntity();
        if (domain.getId() != null) {
            entity.setId(domain.getId());
        }
        entity.setFamDescripcion(domain.getFamDescripcion());
        entity.setFamEstado(domain.getFamEstado());
        entity.setCodfam(domain.getCodfam());
        entity.setUsrSistema(domain.getUsrSistema());
        entity.setFecSistema(domain.getFecSistema());
        entity.setHrsSistema(domain.getHrsSistema());
        return entity;
    }

    public FamiliaProducto toDomain(FamiliaProductoRequest request) {
        if (request == null) return null;
        FamiliaProducto domain = new FamiliaProducto();
        domain.setFamDescripcion(request.famDescripcion());
        domain.setFamEstado(request.famEstado());
        domain.setCodfam(request.codfam());
        domain.setUsrSistema(request.usrSistema());
        domain.setFecSistema(request.fecSistema());
        domain.setHrsSistema(request.hrsSistema());
        return domain;
    }

    public FamiliaProductoResponse toResponse(FamiliaProducto domain) {
        if (domain == null) {
            return null;
        }

        return new FamiliaProductoResponse(
                domain.getId(),
                domain.getFamDescripcion(),
                domain.getFamEstado(),
                domain.getCodfam(),
                domain.getUsrSistema(),
                domain.getFecSistema(),
                domain.getHrsSistema()
        );
    }
}
