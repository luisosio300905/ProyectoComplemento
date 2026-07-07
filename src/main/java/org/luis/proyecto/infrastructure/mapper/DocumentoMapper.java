package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.ComprobantePago;
import org.luis.proyecto.domain.model.Documento;
import org.luis.proyecto.infrastructure.persistence.entity.ComprobantePagoEntity;
import org.luis.proyecto.infrastructure.persistence.entity.DocumentoEntity;
import org.luis.proyecto.infrastructure.rest.request.DocumentoRequest;
import org.luis.proyecto.infrastructure.rest.response.DocumentoResponse;
import org.springframework.stereotype.Component;

@Component
public class DocumentoMapper {

    public DocumentoEntity toEntity(Documento domain) {
        if (domain == null) return null;
        DocumentoEntity entity = new DocumentoEntity();
        entity.setId(domain.getId());
        entity.setDocDescripcion(domain.getDocDescripcion());
        entity.setDocDesCorta(domain.getDocDesCorta());
        entity.setDocAbrev(domain.getDocAbrev());
        entity.setDocEstado(domain.getDocEstado());
        entity.setDocNumDigSerie(domain.getDocNumDigSerie());
        entity.setDocNumDigNumero(domain.getDocNumDigNumero());
        entity.setDocAfaNumerico(domain.getDocAfaNumerico());
        entity.setUsrSistema(domain.getUsrSistema());
        entity.setFecSistema(domain.getFecSistema());
        entity.setHrsSistema(domain.getHrsSistema());
        if (domain.getComprobantePago() != null) {
            ComprobantePagoEntity comprobantePagoEntity = new ComprobantePagoEntity();
            comprobantePagoEntity.setId(domain.getComprobantePago().getId());
            entity.setComprobantePago(comprobantePagoEntity);
        }
        return entity;
    }

    public Documento toDomain(DocumentoEntity entity) {
        if (entity == null) return null;
        Documento domain = new Documento();
        domain.setId(entity.getId());
        domain.setDocDescripcion(entity.getDocDescripcion());
        domain.setDocDesCorta(entity.getDocDesCorta());
        domain.setDocAbrev(entity.getDocAbrev());
        domain.setDocEstado(entity.getDocEstado());
        domain.setDocNumDigSerie(entity.getDocNumDigSerie());
        domain.setDocNumDigNumero(entity.getDocNumDigNumero());
        domain.setDocAfaNumerico(entity.getDocAfaNumerico());
        domain.setUsrSistema(entity.getUsrSistema());
        domain.setFecSistema(entity.getFecSistema());
        domain.setHrsSistema(entity.getHrsSistema());
        if (entity.getComprobantePago() != null) {
            ComprobantePago comprobante = new ComprobantePago();
            comprobante.setId(entity.getComprobantePago().getId());
            domain.setComprobantePago(comprobante);
        }
        return domain;
    }

    public Documento toDomain(DocumentoRequest request) {
        if (request == null) return null;
        Documento domain = new Documento();
        domain.setId(request.id());
        domain.setDocDescripcion(request.docDescripcion());
        domain.setDocDesCorta(request.docDesCorta());
        domain.setDocAbrev(request.docAbrev());
        domain.setDocEstado(request.docEstado());
        domain.setDocNumDigSerie(request.docNumDigSerie());
        domain.setDocNumDigNumero(request.docNumDigNumero());
        domain.setDocAfaNumerico(request.docAfaNumerico());
        domain.setUsrSistema(request.usrSistema());
        domain.setFecSistema(request.fecSistema());
        domain.setHrsSistema(request.hrsSistema());
        if (request.comPagId() != null) {
            ComprobantePago comprobante = new ComprobantePago();
            comprobante.setId(request.comPagId());
            domain.setComprobantePago(comprobante);
        }
        return domain;
    }

    public DocumentoResponse toResponse(Documento domain) {
        if (domain == null) return null;
        return new DocumentoResponse(
            domain.getId(),
            domain.getDocDescripcion(),
            domain.getDocDesCorta(),
            domain.getDocAbrev(),
            domain.getDocEstado(),
            domain.getComprobantePago() != null ? domain.getComprobantePago().getId() : null,
            domain.getDocNumDigSerie(),
            domain.getDocNumDigNumero(),
            domain.getDocAfaNumerico(),
            domain.getUsrSistema(),
            domain.getFecSistema(),
            domain.getHrsSistema()
        );
    }
}

