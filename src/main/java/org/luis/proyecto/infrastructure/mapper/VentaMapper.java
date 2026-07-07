package org.luis.proyecto.infrastructure.mapper;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.infrastructure.persistence.entity.ClienteEntity;
import org.luis.proyecto.infrastructure.persistence.entity.DocumentoEntity;
import org.luis.proyecto.infrastructure.persistence.entity.VentaEntity;
import org.luis.proyecto.infrastructure.rest.request.VentaRequest;
import org.luis.proyecto.infrastructure.rest.response.VentaResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class VentaMapper {
    public Venta toVenta(VentaRequest request) {
        if (request == null) return null;
        Venta v = new Venta();
        v.setEmpresaId(request.empresaId());
        v.setUnidComId(request.unidComId());
        v.setDocId(request.docId());
        v.setVtaCabNumComp(request.vtaCabNumComp());
        v.setClienId(request.clienId());
        v.setMonedaId(request.monedaId());
        v.setVtaCabFecha(request.vtaCabFecha());
        v.setVtaValCamb(request.vtaValCamb());
        v.setVtaCabAccImp(request.vtaCabAccImp());
        v.setVtaComAccAnu(request.vtaComAccAnu());
        v.setCondComId(request.condComId());
        v.setVtaCabEstCanc(request.vtaCabEstCanc());
        v.setVtaCabCierre(request.vtaCabCierre());
        v.setVtaCabActPlla(request.vtaCabActPlla());
        v.setVtaCabAfecDetrac(request.vtaCabAfecDetrac());
        v.setVtaCabContDetrac(request.vtaCabContDetrac());
        v.setTipOpeComId(request.tipOpeComId());
        v.setVtaCabNumRef(request.vtaCabNumRef());
        v.setVtaCabValorVta(request.vtaCabValorVta());
        v.setVtaCabValorVtaExo(request.vtaCabValorVtaExo());
        v.setVtaCabValIGV(request.vtaCabValIGV());
        v.setVtaCabValISC(request.vtaCabValISC());
        v.setVtaCabValTotal(request.vtaCabValTotal());
        v.setVtaCabValMonPago(request.vtaCabValMonPago());
        v.setVtaCabValVuelto(request.vtaCabValVuelto());
        v.setVtaCabNamePaciente(request.vtaCabNamePaciente());
        v.setUsrSistema(request.usrSistema());
        v.setFecSistema(request.fecSistema());
        v.setHrsSistema(request.hrsSistema());
        v.setVtaCabDsctoGlobal(request.vtaCabDsctoGlobal());
        v.setVtaCabFechaVcto(request.vtaCabFechaVcto());
        return v;
    }
    public Venta toVenta(VentaEntity entity) {
        if (entity == null) return null;
        Venta v = new Venta();
        v.setId(entity.getId());
        v.setEmpresaId(entity.getEmpresaId());
        v.setUnidComId(entity.getUnidComId());
        v.setDocId(entity.getDocumento() != null ? entity.getDocumento().getId() : null);
        v.setVtaCabNumComp(entity.getVtaCabNumComp());
        v.setClienId(entity.getCliente() != null ? entity.getCliente().getId().longValue() : null);
        v.setMonedaId(entity.getMonedaId());
        v.setVtaCabFecha(entity.getVtaCabFecha());
        v.setVtaValCamb(entity.getVtaValCamb());
        v.setVtaCabAccImp(entity.getVtaCabAccImp());
        v.setVtaComAccAnu(entity.getVtaComAccAnu());
        v.setCondComId(entity.getCondComId());
        v.setVtaCabEstCanc(entity.getVtaCabEstCanc());
        v.setVtaCabCierre(entity.getVtaCabCierre());
        v.setVtaCabActPlla(entity.getVtaCabActPlla());
        v.setVtaCabAfecDetrac(entity.getVtaCabAfecDetrac());
        v.setVtaCabContDetrac(entity.getVtaCabContDetrac());
        v.setTipOpeComId(entity.getTipOpeComId());
        v.setVtaCabNumRef(entity.getVtaCabNumRef());
        v.setVtaCabValorVta(entity.getVtaCabValorVta());
        v.setVtaCabValorVtaExo(entity.getVtaCabValorVtaExo());
        v.setVtaCabValIGV(entity.getVtaCabValIGV());
        v.setVtaCabValISC(entity.getVtaCabValISC());
        v.setVtaCabValTotal(entity.getVtaCabValTotal());
        v.setVtaCabValMonPago(entity.getVtaCabValMonPago());
        v.setVtaCabValVuelto(entity.getVtaCabValVuelto());
        v.setVtaCabNamePaciente(entity.getVtaCabNamePaciente());
        v.setUsrSistema(entity.getUsrSistema());
        v.setFecSistema(entity.getFecSistema());
        v.setHrsSistema(entity.getHrsSistema());
        v.setVtaCabDsctoGlobal(entity.getVtaCabDsctoGlobal());
        v.setVtaCabFechaVcto(entity.getVtaCabFechaVcto());
        return v;
    }
    public VentaEntity toVentaEntity(Venta venta) {
        if (venta == null) return null;
        VentaEntity e = new VentaEntity();
        e.setId(venta.getId());
        e.setEmpresaId(venta.getEmpresaId());
        e.setUnidComId(venta.getUnidComId());
        if (venta.getDocId() != null) {
            DocumentoEntity doc = new DocumentoEntity();
            doc.setId(venta.getDocId());
            e.setDocumento(doc);
        }
        e.setVtaCabNumComp(venta.getVtaCabNumComp());
        if (venta.getClienId() != null) {
            ClienteEntity cli = new ClienteEntity();
            cli.setId(venta.getClienId().intValue());
            e.setCliente(cli);
        }
        e.setMonedaId(venta.getMonedaId());
        e.setVtaCabFecha(venta.getVtaCabFecha());
        e.setVtaValCamb(venta.getVtaValCamb());
        e.setVtaCabAccImp(venta.getVtaCabAccImp());
        e.setVtaComAccAnu(venta.getVtaComAccAnu());
        e.setCondComId(venta.getCondComId());
        e.setVtaCabEstCanc(venta.getVtaCabEstCanc());
        e.setVtaCabCierre(venta.getVtaCabCierre());
        e.setVtaCabActPlla(venta.getVtaCabActPlla());
        e.setVtaCabAfecDetrac(venta.getVtaCabAfecDetrac());
        e.setVtaCabContDetrac(venta.getVtaCabContDetrac());
        e.setTipOpeComId(venta.getTipOpeComId());
        e.setVtaCabNumRef(venta.getVtaCabNumRef());
        e.setVtaCabValorVta(venta.getVtaCabValorVta());
        e.setVtaCabValorVtaExo(venta.getVtaCabValorVtaExo());
        e.setVtaCabValIGV(venta.getVtaCabValIGV());
        e.setVtaCabValISC(venta.getVtaCabValISC());
        e.setVtaCabValTotal(venta.getVtaCabValTotal());
        e.setVtaCabValMonPago(venta.getVtaCabValMonPago());
        e.setVtaCabValVuelto(venta.getVtaCabValVuelto());
        e.setVtaCabNamePaciente(venta.getVtaCabNamePaciente());
        e.setUsrSistema(venta.getUsrSistema());
        e.setFecSistema(venta.getFecSistema());
        e.setHrsSistema(venta.getHrsSistema());
        e.setVtaCabDsctoGlobal(venta.getVtaCabDsctoGlobal());
        e.setVtaCabFechaVcto(venta.getVtaCabFechaVcto());
        return e;
    }
    public VentaResponse toVentaResponse(Venta venta) {
        if (venta == null) return null;
        return new VentaResponse(
            venta.getId(),
venta.getEmpresaId(),
            venta.getUnidComId(),
            venta.getDocId(),
            venta.getVtaCabNumComp(),
            venta.getClienId(),
            venta.getMonedaId(),
            venta.getVtaCabFecha(),
            venta.getVtaValCamb(),
            venta.getVtaCabAccImp(),
            venta.getVtaComAccAnu(),
            venta.getCondComId(),
            venta.getVtaCabEstCanc(),
            venta.getVtaCabCierre(),
            venta.getVtaCabActPlla(),
            venta.getVtaCabAfecDetrac(),
            venta.getVtaCabContDetrac(),
            venta.getTipOpeComId(),
            venta.getVtaCabNumRef(),
            venta.getVtaCabValorVta(),
            venta.getVtaCabValorVtaExo(),
            venta.getVtaCabValIGV(),
            venta.getVtaCabValISC(),
            venta.getVtaCabValTotal(),
            venta.getVtaCabValMonPago(),
            venta.getVtaCabValVuelto(),
            venta.getVtaCabNamePaciente(),
            venta.getUsrSistema(),
            venta.getFecSistema(),
            venta.getHrsSistema(),
            venta.getVtaCabDsctoGlobal(),
            venta.getVtaCabFechaVcto()
        );
    }
    public List<VentaResponse> toVentaResponseList(List<Venta> ventas) {
        if(ventas == null) return null;
        return ventas.stream().map(this::toVentaResponse).collect(Collectors.toList());
    }
    public List<Venta> toVentaList(List<VentaEntity> entities) {
        if(entities == null) return null;
        return entities.stream().map(this::toVenta).collect(Collectors.toList());
    }
}
