package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.infrastructure.persistence.entity.DiarioCabeceraEntity;
import org.luis.proyecto.infrastructure.rest.request.DiarioCabeceraRequest;
import org.luis.proyecto.infrastructure.rest.response.DiarioCabeceraResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiarioCabeceraMapper {

    private final DiarioDetalleMapper diarioDetalleMapper;

    public DiarioCabeceraMapper(DiarioDetalleMapper diarioDetalleMapper) {
        this.diarioDetalleMapper = diarioDetalleMapper;
    }

    public DiarioCabecera toDiarioCabecera(DiarioCabeceraEntity diarioCabeceraEntity) {
        if (diarioCabeceraEntity == null) return null;
        DiarioCabecera diarioCabecera = new DiarioCabecera();
        diarioCabecera.setDiaCabCompId(diarioCabeceraEntity.getDiaCabCompId());
        diarioCabecera.setDiaCabAno(diarioCabeceraEntity.getDiaCabAno());
        diarioCabecera.setDiaCabMes(diarioCabeceraEntity.getDiaCabMes());
        diarioCabecera.setEmpresaId(diarioCabeceraEntity.getEmpresaId());
        diarioCabecera.setDiaCabFec(diarioCabeceraEntity.getDiaCabFec());
        diarioCabecera.setDiaCabGlosa(diarioCabeceraEntity.getDiaCabGlosa());
        diarioCabecera.setDiaCabAccImp(diarioCabeceraEntity.getDiaCabAccImp());
        diarioCabecera.setDiaCabAccEdi(diarioCabeceraEntity.getDiaCabAccEdi());
        diarioCabecera.setSubMovId(diarioCabeceraEntity.getSubMovId());
        diarioCabecera.setMovConId(diarioCabeceraEntity.getMovConId());
        diarioCabecera.setUsrSistema(diarioCabeceraEntity.getUsrSistema());
        diarioCabecera.setFecSistema(diarioCabeceraEntity.getFecSistema());
        diarioCabecera.setHrsSistema(diarioCabeceraEntity.getHrsSistema());
        if (diarioCabeceraEntity.getDetalles() != null) {
            try {
                diarioCabecera.setDetalles(diarioCabeceraEntity.getDetalles().stream()
                        .map(diarioDetalleMapper::toDiarioDetalle)
                        .collect(Collectors.toList()));
            } catch (Exception e) {
                // Ignore lazy initialization issues
            }
        }
        return diarioCabecera;
    }

    public DiarioCabeceraEntity toDiarioCabeceraEntity(DiarioCabecera diarioCabecera) {
        if (diarioCabecera == null) return null;
        DiarioCabeceraEntity diarioCabeceraEntity = new DiarioCabeceraEntity();
        if (diarioCabecera.getDiaCabCompId() != null) {
            diarioCabeceraEntity.setDiaCabCompId(diarioCabecera.getDiaCabCompId());
        }
        diarioCabeceraEntity.setDiaCabAno(diarioCabecera.getDiaCabAno());
        diarioCabeceraEntity.setDiaCabMes(diarioCabecera.getDiaCabMes());
        diarioCabeceraEntity.setEmpresaId(diarioCabecera.getEmpresaId());
        diarioCabeceraEntity.setDiaCabFec(diarioCabecera.getDiaCabFec());
        diarioCabeceraEntity.setDiaCabGlosa(diarioCabecera.getDiaCabGlosa());
        diarioCabeceraEntity.setDiaCabAccImp(diarioCabecera.getDiaCabAccImp());
        diarioCabeceraEntity.setDiaCabAccEdi(diarioCabecera.getDiaCabAccEdi());
        diarioCabeceraEntity.setSubMovId(diarioCabecera.getSubMovId());
        diarioCabeceraEntity.setMovConId(diarioCabecera.getMovConId());
        diarioCabeceraEntity.setUsrSistema(diarioCabecera.getUsrSistema());
        diarioCabeceraEntity.setFecSistema(diarioCabecera.getFecSistema());
        diarioCabeceraEntity.setHrsSistema(diarioCabecera.getHrsSistema());
        if (diarioCabecera.getDetalles() != null) {
            diarioCabeceraEntity.setDetalles(diarioCabecera.getDetalles().stream()
                    .map(diarioDetalleMapper::toDiarioDetalleEntity)
                    .collect(Collectors.toList()));
            diarioCabeceraEntity.getDetalles().forEach(d -> d.setDiarioCabecera(diarioCabeceraEntity));
        }
        return diarioCabeceraEntity;
    }

    public DiarioCabecera toDiarioCabecera(DiarioCabeceraRequest diarioCabeceraRequest) {
        DiarioCabecera diarioCabecera = new DiarioCabecera();
        diarioCabecera.setDiaCabAno(diarioCabeceraRequest.diaCabAno());
        diarioCabecera.setDiaCabMes(diarioCabeceraRequest.diaCabMes());
        diarioCabecera.setEmpresaId(diarioCabeceraRequest.empresaId());
        diarioCabecera.setDiaCabFec(diarioCabeceraRequest.diaCabFec());
        diarioCabecera.setDiaCabGlosa(diarioCabeceraRequest.diaCabGlosa());
        diarioCabecera.setDiaCabAccImp(diarioCabeceraRequest.diaCabAccImp());
        diarioCabecera.setDiaCabAccEdi(diarioCabeceraRequest.diaCabAccEdi());
        diarioCabecera.setSubMovId(diarioCabeceraRequest.subMovId());
        diarioCabecera.setMovConId(diarioCabeceraRequest.movConId());
        diarioCabecera.setUsrSistema(diarioCabeceraRequest.usrSistema());
        diarioCabecera.setFecSistema(diarioCabeceraRequest.fecSistema());
        diarioCabecera.setHrsSistema(diarioCabeceraRequest.hrsSistema());
        return diarioCabecera;
    }

    public List<DiarioCabecera> toDiarioCabeceraList(List<DiarioCabeceraEntity> diarioCabeceraEntities) {
        return diarioCabeceraEntities
                .stream()
                .map(this::toDiarioCabecera)
                .toList();
    }

    public DiarioCabeceraResponse toDiarioCabeceraResponse(DiarioCabecera diarioCabecera) {
        return new DiarioCabeceraResponse(
                diarioCabecera.getDiaCabCompId(),
                diarioCabecera.getDiaCabAno(),
                diarioCabecera.getDiaCabMes(),
                diarioCabecera.getEmpresaId(),
                diarioCabecera.getDiaCabFec(),
                diarioCabecera.getDiaCabGlosa(),
                diarioCabecera.getDiaCabAccImp(),
                diarioCabecera.getDiaCabAccEdi(),
                diarioCabecera.getSubMovId(),
                diarioCabecera.getMovConId(),
                diarioCabecera.getUsrSistema(),
                diarioCabecera.getFecSistema(),
                diarioCabecera.getHrsSistema()
        );
    }

    public List<DiarioCabeceraResponse> toDiarioCabeceraResponseList(List<DiarioCabecera> diarioCabeceras) {
        return diarioCabeceras
                .stream()
                .map(this::toDiarioCabeceraResponse)
                .toList();
    }
}

