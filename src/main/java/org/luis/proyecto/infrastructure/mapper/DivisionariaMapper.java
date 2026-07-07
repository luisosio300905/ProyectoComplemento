package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Divisionaria;
import org.luis.proyecto.infrastructure.persistence.entity.DivisionariaEntity;
import org.luis.proyecto.infrastructure.rest.request.DivisionariaRequest;
import org.luis.proyecto.infrastructure.rest.response.DivisionariaResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DivisionariaMapper {
    public Divisionaria toDivisionaria(DivisionariaEntity entity) {
        Divisionaria divisionaria = new Divisionaria();
        divisionaria.setCuentaId(entity.getCuentaId());
        divisionaria.setSubCtaId(entity.getSubCtaId());
        divisionaria.setDivisioId(entity.getDivisioId());
        divisionaria.setDivisioDescripcion(entity.getDivisioDescripcion());
        divisionaria.setDivisioEstad(entity.getDivisioEstad());
        divisionaria.setUsrSistema(entity.getUsrSistema());
        divisionaria.setFecSistema(entity.getFecSistema());
        divisionaria.setHrsSistema(entity.getHrsSistema());
        return divisionaria;
    }

    public DivisionariaEntity toDivisionariaEntity(Divisionaria divisionaria) {
        DivisionariaEntity entity = new DivisionariaEntity();
        entity.setCuentaId(divisionaria.getCuentaId());
        entity.setSubCtaId(divisionaria.getSubCtaId());
        entity.setDivisioId(divisionaria.getDivisioId());
        entity.setDivisioDescripcion(divisionaria.getDivisioDescripcion());
        entity.setDivisioEstad(divisionaria.getDivisioEstad());
        entity.setUsrSistema(divisionaria.getUsrSistema());
        entity.setFecSistema(divisionaria.getFecSistema());
        entity.setHrsSistema(divisionaria.getHrsSistema());
        return entity;
    }

    public Divisionaria toDivisionaria(DivisionariaRequest request) {
        Divisionaria divisionaria = new Divisionaria();
        divisionaria.setCuentaId(request.cuentaId());
        divisionaria.setSubCtaId(request.subCtaId());
        divisionaria.setDivisioId(request.divisioId());
        divisionaria.setDivisioDescripcion(request.divisioDescripcion());
        divisionaria.setDivisioEstad(request.divisioEstad());
        divisionaria.setUsrSistema(request.usrSistema());
        divisionaria.setFecSistema(request.fecSistema());
        divisionaria.setHrsSistema(request.hrsSistema());
        return divisionaria;
    }

    public List<Divisionaria> toDivisionariaList(List<DivisionariaEntity> entities) {
        return entities.stream().map(this::toDivisionaria).toList();
    }

    public DivisionariaResponse toDivisionariaResponse(Divisionaria divisionaria) {
        return new DivisionariaResponse(
                divisionaria.getCuentaId(),
                divisionaria.getSubCtaId(),
                divisionaria.getDivisioId(),
                divisionaria.getDivisioDescripcion(),
                divisionaria.getDivisioEstad(),
                divisionaria.getUsrSistema(),
                divisionaria.getFecSistema(),
                divisionaria.getHrsSistema()
        );
    }

    public List<DivisionariaResponse> toDivisionariaResponseList(List<Divisionaria> divisionarias) {
        return divisionarias.stream().map(this::toDivisionariaResponse).toList();
    }
}

