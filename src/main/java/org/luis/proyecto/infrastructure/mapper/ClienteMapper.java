package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.infrastructure.persistence.entity.ClienteEntity;
import org.luis.proyecto.infrastructure.rest.request.ClienteRequest;
import org.luis.proyecto.infrastructure.rest.response.ClienteResponse;
import org.luis.proyecto.infrastructure.persistence.repository.JpaTipoDocumentoIdentidadRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    private final JpaTipoDocumentoIdentidadRepository jpaTipoDocumentoIdentidadRepository;

    public ClienteMapper(JpaTipoDocumentoIdentidadRepository jpaTipoDocumentoIdentidadRepository) {
        this.jpaTipoDocumentoIdentidadRepository = jpaTipoDocumentoIdentidadRepository;
    }

    public Cliente toCliente(ClienteEntity entity) {
        if (entity == null) return null;
        Cliente domain = new Cliente();
        domain.setId(entity.getId());
        domain.setClienDescripcion(entity.getClienDescripcion());
        domain.setClienRazSoc(entity.getClienRazSoc());
        domain.setClienNomCor(entity.getClienNomCor());
        domain.setClienSiglas(entity.getClienSiglas());
        if (entity.getTipoDocumentoIdentidad() != null) domain.setTipDocIdenId(entity.getTipoDocumentoIdentidad().getId());
        domain.setClienDoc(entity.getClienDoc());
        domain.setClienRegCom(entity.getClienRegCom());
        domain.setClienDireccion(entity.getClienDireccion());
        domain.setClienTelef01(entity.getClienTelef01());
        domain.setClienTelef02(entity.getClienTelef02());
        domain.setClienFax(entity.getClienFax());
        domain.setClienCelular(entity.getClienCelular());
        domain.setClienMail(entity.getClienMail());
        domain.setClienWeb(entity.getClienWeb());
        domain.setClienContacto(entity.getClienContacto());
        domain.setClienFecIng(entity.getClienFecIng());
        domain.setClienEstado(entity.getClienEstado());
        domain.setClienGiro(entity.getClienGiro());
        domain.setClienUltVta(entity.getClienUltVta());
        domain.setCtaCteId(entity.getCtaCteId());
        domain.setDptoGeoId(entity.getDptoGeoId());
        domain.setProvGeoId(entity.getProvGeoId());
        domain.setDistGeoId(entity.getDistGeoId());
        domain.setUsrSistema(entity.getUsrSistema());
        domain.setFecSistema(entity.getFecSistema());
        domain.setHrsSistema(entity.getHrsSistema());
        return domain;
    }

    public ClienteEntity toClienteEntity(Cliente domain) {
        if (domain == null) return null;
        ClienteEntity entity = new ClienteEntity();
        entity.setId(domain.getId());
        entity.setClienDescripcion(domain.getClienDescripcion());
        entity.setClienRazSoc(domain.getClienRazSoc());
        entity.setClienNomCor(domain.getClienNomCor());
        entity.setClienSiglas(domain.getClienSiglas());
        if (domain.getTipDocIdenId() != null) {
            entity.setTipoDocumentoIdentidad(jpaTipoDocumentoIdentidadRepository.findById(domain.getTipDocIdenId()).orElse(null));
        }
        entity.setClienDoc(domain.getClienDoc());
        entity.setClienRegCom(domain.getClienRegCom());
        entity.setClienDireccion(domain.getClienDireccion());
        entity.setClienTelef01(domain.getClienTelef01());
        entity.setClienTelef02(domain.getClienTelef02());
        entity.setClienFax(domain.getClienFax());
        entity.setClienCelular(domain.getClienCelular());
        entity.setClienMail(domain.getClienMail());
        entity.setClienWeb(domain.getClienWeb());
        entity.setClienContacto(domain.getClienContacto());
        entity.setClienFecIng(domain.getClienFecIng());
        entity.setClienEstado(domain.getClienEstado());
        entity.setClienGiro(domain.getClienGiro());
        entity.setClienUltVta(domain.getClienUltVta());
        entity.setCtaCteId(domain.getCtaCteId());
        entity.setDptoGeoId(domain.getDptoGeoId());
        entity.setProvGeoId(domain.getProvGeoId());
        entity.setDistGeoId(domain.getDistGeoId());
        entity.setUsrSistema(domain.getUsrSistema());
        entity.setFecSistema(domain.getFecSistema());
        entity.setHrsSistema(domain.getHrsSistema());
        return entity;
    }

    public Cliente toCliente(ClienteRequest request) {
        if (request == null) return null;
        Cliente domain = new Cliente();
        domain.setClienDescripcion(request.clienDescripcion());
        domain.setClienRazSoc(request.clienRazSoc());
        domain.setClienNomCor(request.clienNomCor());
        domain.setClienSiglas(request.clienSiglas());
        domain.setTipDocIdenId(request.tipDocIdenId());
        domain.setClienDoc(request.clienDoc());
        domain.setClienRegCom(request.clienRegCom());
        domain.setClienDireccion(request.clienDireccion());
        domain.setClienTelef01(request.clienTelef01());
        domain.setClienTelef02(request.clienTelef02());
        domain.setClienFax(request.clienFax());
        domain.setClienCelular(request.clienCelular());
        domain.setClienMail(request.clienMail());
        domain.setClienWeb(request.clienWeb());
        domain.setClienContacto(request.clienContacto());
        domain.setClienFecIng(request.clienFecIng());
        domain.setClienEstado(request.clienEstado());
        domain.setClienGiro(request.clienGiro());
        domain.setClienUltVta(request.clienUltVta());
        domain.setCtaCteId(request.ctaCteId());
        domain.setDptoGeoId(request.dptoGeoId());
        domain.setProvGeoId(request.provGeoId());
        domain.setDistGeoId(request.distGeoId());
        domain.setUsrSistema(request.usrSistema());
        domain.setFecSistema(request.fecSistema());
        domain.setHrsSistema(request.hrsSistema());
        return domain;
    }

    public ClienteResponse toClienteResponse(Cliente domain) {
        if (domain == null) return null;
        return new ClienteResponse(
            domain.getId(),
            domain.getClienDescripcion(),
            domain.getClienRazSoc(),
            domain.getClienNomCor(),
            domain.getClienSiglas(),
            domain.getTipDocIdenId(),
            domain.getClienDoc(),
            domain.getClienRegCom(),
            domain.getClienDireccion(),
            domain.getClienTelef01(),
            domain.getClienTelef02(),
            domain.getClienFax(),
            domain.getClienCelular(),
            domain.getClienMail(),
            domain.getClienWeb(),
            domain.getClienContacto(),
            domain.getClienFecIng(),
            domain.getClienEstado(),
            domain.getClienGiro(),
            domain.getClienUltVta(),
            domain.getCtaCteId(),
            domain.getDptoGeoId(),
            domain.getProvGeoId(),
            domain.getDistGeoId(),
            domain.getUsrSistema(),
            domain.getFecSistema(),
            domain.getHrsSistema()
        );
    }

    public List<Cliente> toClienteList(List<ClienteEntity> entities) {
        if (entities == null) return null;
        return entities.stream().map(this::toCliente).collect(Collectors.toList());
    }

    public List<ClienteEntity> toClienteEntityList(List<Cliente> domains) {
        if (domains == null) return null;
        return domains.stream().map(this::toClienteEntity).collect(Collectors.toList());
    }

    public List<ClienteResponse> toClienteResponseList(List<Cliente> domains) {
        if (domains == null) return null;
        return domains.stream().map(this::toClienteResponse).collect(Collectors.toList());
    }
}
