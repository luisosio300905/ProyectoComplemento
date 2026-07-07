package org.luis.proyecto.infrastructure.mapper;
import org.luis.proyecto.domain.model.DetalleVenta;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.infrastructure.persistence.entity.DetalleVentaEntity;
import org.luis.proyecto.infrastructure.persistence.entity.ProductoEntity;
import org.luis.proyecto.infrastructure.persistence.entity.VentaEntity;
import org.luis.proyecto.infrastructure.rest.request.DetalleVentaRequest;
import org.luis.proyecto.infrastructure.rest.response.DetalleVentaResponse;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentaMapper {

    public DetalleVenta toDetalleVenta(DetalleVentaRequest request) {
        if(request == null) return null;
        DetalleVenta d = new DetalleVenta();
        if(request.idVenta() != null) {
            Venta v = new Venta();
            v.setId(request.idVenta());
            d.setVenta(v);
        }
        d.setEmpresaId(request.empresaId());
        d.setUnidComId(request.unidComId());
        d.setDocId(request.docId());
        d.setVtaCabNumComp(request.vtaCabNumComp());
        d.setIteAlmId(request.iteAlmId());
        d.setVtaDetCodref(request.vtaDetCodref());
        d.setVtaDetItem(request.vtaDetItem());
        d.setVtaDetCantidad(request.vtaDetCantidad());
        d.setVtaDetPrecUnit(request.vtaDetPrecUnit());
        d.setVtaDetValorVta(request.vtaDetValorVta());
        d.setVtaDetValIGV(request.vtaDetValIGV());
        d.setVtaDetValISC(request.vtaDetValISC());
        d.setVtaDetValTot(request.vtaDetValTot());
        d.setTipVtaId(request.tipVtaId());
        d.setTipAlmId(request.tipAlmId());
        d.setAlmacenId(request.almacenId());
        d.setVtaDetFracUni(request.vtaDetFracUni());
        d.setVtaDetCantFrac(request.vtaDetCantFrac());
        d.setUsrSistema(request.usrSistema());
        d.setFecSistema(request.fecSistema());
        d.setHrsSistema(request.hrsSistema());
        d.setVtaDetValIna(request.vtaDetValIna());

        return d;
    }

    public DetalleVenta toDetalleVenta(DetalleVentaEntity entity) {
        if(entity == null) return null;
        DetalleVenta d = new DetalleVenta();
        d.setId(entity.getId());
        if(entity.getVenta() != null) {
            Venta v = new Venta();
            v.setId(entity.getVenta().getId());
            d.setVenta(v);
        }
        d.setEmpresaId(entity.getEmpresaId());
        d.setUnidComId(entity.getUnidComId());
        d.setDocId(entity.getDocId());
        d.setVtaCabNumComp(entity.getVtaCabNumComp());
        d.setIteAlmId(entity.getProducto().getIteAlmId());
        d.setVtaDetCodref(1); //corregir
        d.setVtaDetItem(entity.getVtaDetItem());
        d.setVtaDetCantidad(entity.getVtaDetCantidad());
        d.setVtaDetPrecUnit(entity.getVtaDetPrecUnit());
        d.setVtaDetValorVta(entity.getVtaDetValorVta());
        d.setVtaDetValIGV(entity.getVtaDetValIGV());
        d.setVtaDetValISC(entity.getVtaDetValISC());
        d.setVtaDetValTot(entity.getVtaDetValTot());
        d.setTipVtaId(entity.getTipVtaId());
        d.setTipAlmId(entity.getTipAlmId());
        d.setAlmacenId(entity.getAlmacenId());
        d.setVtaDetFracUni(entity.getVtaDetFracUni());
        d.setVtaDetCantFrac(entity.getVtaDetCantFrac());
        d.setUsrSistema(entity.getUsrSistema());
        d.setFecSistema(entity.getFecSistema());
        d.setHrsSistema(entity.getHrsSistema());
        d.setVtaDetValIna(entity.getVtaDetValIna());

        return d;
    }

    public DetalleVentaEntity toDetalleVentaEntity(DetalleVenta dv) {
        if(dv == null) return null;
        DetalleVentaEntity e = new DetalleVentaEntity();
        e.setId(dv.getId());
        if(dv.getVenta() != null) {
            VentaEntity v = new VentaEntity();
            v.setId(dv.getVenta().getId());
            e.setVenta(v);
        }
        e.setEmpresaId(dv.getEmpresaId());
        e.setUnidComId(dv.getUnidComId());
        e.setDocId(dv.getDocId());
        e.setVtaCabNumComp(dv.getVtaCabNumComp());
        ProductoEntity p = new ProductoEntity();
        p.setIteAlmId(dv.getIteAlmId());
        e.setProducto(p);
        e.setVtaDetItem(dv.getVtaDetItem());
        e.setVtaDetCantidad(dv.getVtaDetCantidad());
        e.setVtaDetPrecUnit(dv.getVtaDetPrecUnit());
        e.setVtaDetValorVta(dv.getVtaDetValorVta());
        e.setVtaDetValIGV(dv.getVtaDetValIGV());
        e.setVtaDetValISC(dv.getVtaDetValISC());
        e.setVtaDetValTot(dv.getVtaDetValTot());
        e.setTipVtaId(dv.getTipVtaId());
        e.setTipAlmId(dv.getTipAlmId());
        e.setAlmacenId(dv.getAlmacenId());
        e.setVtaDetFracUni(dv.getVtaDetFracUni());
        e.setVtaDetCantFrac(dv.getVtaDetCantFrac());
        e.setUsrSistema(dv.getUsrSistema());
        e.setFecSistema(dv.getFecSistema());
        e.setHrsSistema(dv.getHrsSistema());
        e.setVtaDetValIna(dv.getVtaDetValIna());

        return e;
    }

    public DetalleVentaResponse toDetalleVentaResponse(DetalleVenta dv) {
        if(dv == null) return null;
        return new DetalleVentaResponse(
            dv.getId(),
            dv.getEmpresaId(),
            dv.getUnidComId(),
            dv.getDocId(),
            dv.getVtaCabNumComp(),
            dv.getVtaDetCodref(),
            dv.getIteAlmId(),
            dv.getVtaDetItem(),
            dv.getVtaDetCantidad(),
            dv.getVtaDetPrecUnit(),
            dv.getVtaDetValorVta(),
            dv.getVtaDetValIGV(),
            dv.getVtaDetValISC(),
            dv.getVtaDetValTot(),
            dv.getTipVtaId(),
            dv.getTipAlmId(),
            dv.getAlmacenId(),
            dv.getVtaDetFracUni(),
            dv.getVtaDetCantFrac(),
            dv.getUsrSistema(),
            dv.getFecSistema(),
            dv.getHrsSistema(),
            dv.getVtaDetValIna()
        );
    }

    public java.util.List<DetalleVenta> toDetalleVentaList(java.util.List<DetalleVentaEntity> entities) {
        if(entities == null) return null;
        return entities.stream().map(this::toDetalleVenta).collect(java.util.stream.Collectors.toList());
    }

    public java.util.List<DetalleVentaResponse> toDetalleVentaResponseList(java.util.List<DetalleVenta> dvs) {
        if(dvs == null) return null;
        return dvs.stream().map(this::toDetalleVentaResponse).collect(java.util.stream.Collectors.toList());
    }
}
