package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Cuenta;
import org.luis.proyecto.infrastructure.persistence.entity.CuentaEntity;
import org.luis.proyecto.infrastructure.rest.request.CuentaRequest;
import org.luis.proyecto.infrastructure.rest.response.CuentaResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CuentaMapper {
    public Cuenta toCuenta(CuentaEntity entity) {
        Cuenta cuenta = new Cuenta();
        cuenta.setCuentaId(entity.getCuentaId());
        cuenta.setCuentaDescripcion(entity.getCuentaDescripcion());
        cuenta.setCuentaEstado(entity.getCuentaEstado());
        cuenta.setUsrSistema(entity.getUsrSistema());
        cuenta.setFecSistema(entity.getFecSistema());
        cuenta.setHrsSistema(entity.getHrsSistema());
        return cuenta;
    }

    public CuentaEntity toCuentaEntity(Cuenta cuenta) {
        CuentaEntity entity = new CuentaEntity();
        entity.setCuentaId(cuenta.getCuentaId());
        entity.setCuentaDescripcion(cuenta.getCuentaDescripcion());
        entity.setCuentaEstado(cuenta.getCuentaEstado());
        entity.setUsrSistema(cuenta.getUsrSistema());
        entity.setFecSistema(cuenta.getFecSistema());
        entity.setHrsSistema(cuenta.getHrsSistema());
        return entity;
    }

    public Cuenta toCuenta(CuentaRequest request) {
        Cuenta cuenta = new Cuenta();
        cuenta.setCuentaId(request.cuentaId());
        cuenta.setCuentaDescripcion(request.cuentaDescripcion());
        cuenta.setCuentaEstado(request.cuentaEstado());
        cuenta.setUsrSistema(request.usrSistema());
        cuenta.setFecSistema(request.fecSistema());
        cuenta.setHrsSistema(request.hrsSistema());
        return cuenta;
    }

    public List<Cuenta> toCuentaList(List<CuentaEntity> entities) {
        return entities.stream().map(this::toCuenta).toList();
    }

    public CuentaResponse toCuentaResponse(Cuenta cuenta) {
        return new CuentaResponse(
                cuenta.getCuentaId(),
                cuenta.getCuentaDescripcion(),
                cuenta.getCuentaEstado(),
                cuenta.getUsrSistema(),
                cuenta.getFecSistema(),
                cuenta.getHrsSistema()
        );
    }

    public List<CuentaResponse> toCuentaResponseList(List<Cuenta> cuentas) {
        return cuentas.stream().map(this::toCuentaResponse).toList();
    }
}

