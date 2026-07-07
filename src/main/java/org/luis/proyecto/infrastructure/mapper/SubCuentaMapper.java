package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.SubCuenta;
import org.luis.proyecto.infrastructure.persistence.entity.SubCuentaEntity;
import org.luis.proyecto.infrastructure.rest.request.SubCuentaRequest;
import org.luis.proyecto.infrastructure.rest.response.SubCuentaResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubCuentaMapper {
    public SubCuenta toSubCuenta(SubCuentaEntity entity) {
        SubCuenta subCuenta = new SubCuenta();
        subCuenta.setCuentaId(entity.getCuentaId());
        subCuenta.setSubCtaId(entity.getSubCtaId());
        subCuenta.setSubCtaDescripcion(entity.getSubCtaDescripcion());
        subCuenta.setSubCtaEstado(entity.getSubCtaEstado());
        subCuenta.setUsrSistema(entity.getUsrSistema());
        subCuenta.setFecSistema(entity.getFecSistema());
        subCuenta.setHrsSistema(entity.getHrsSistema());
        return subCuenta;
    }

    public SubCuentaEntity toSubCuentaEntity(SubCuenta subCuenta) {
        SubCuentaEntity entity = new SubCuentaEntity();
        entity.setCuentaId(subCuenta.getCuentaId());
        entity.setSubCtaId(subCuenta.getSubCtaId());
        entity.setSubCtaDescripcion(subCuenta.getSubCtaDescripcion());
        entity.setSubCtaEstado(subCuenta.getSubCtaEstado());
        entity.setUsrSistema(subCuenta.getUsrSistema());
        entity.setFecSistema(subCuenta.getFecSistema());
        entity.setHrsSistema(subCuenta.getHrsSistema());
        return entity;
    }

    public SubCuenta toSubCuenta(SubCuentaRequest request) {
        SubCuenta subCuenta = new SubCuenta();
        subCuenta.setCuentaId(request.cuentaId());
        subCuenta.setSubCtaId(request.subCtaId());
        subCuenta.setSubCtaDescripcion(request.subCtaDescripcion());
        subCuenta.setSubCtaEstado(request.subCtaEstado());
        subCuenta.setUsrSistema(request.usrSistema());
        subCuenta.setFecSistema(request.fecSistema());
        subCuenta.setHrsSistema(request.hrsSistema());
        return subCuenta;
    }

    public List<SubCuenta> toSubCuentaList(List<SubCuentaEntity> entities) {
        return entities.stream().map(this::toSubCuenta).toList();
    }

    public SubCuentaResponse toSubCuentaResponse(SubCuenta subCuenta) {
        return new SubCuentaResponse(
                subCuenta.getCuentaId(),
                subCuenta.getSubCtaId(),
                subCuenta.getSubCtaDescripcion(),
                subCuenta.getSubCtaEstado(),
                subCuenta.getUsrSistema(),
                subCuenta.getFecSistema(),
                subCuenta.getHrsSistema()
        );
    }

    public List<SubCuentaResponse> toSubCuentaResponseList(List<SubCuenta> subCuentas) {
        return subCuentas.stream().map(this::toSubCuentaResponse).toList();
    }
}

