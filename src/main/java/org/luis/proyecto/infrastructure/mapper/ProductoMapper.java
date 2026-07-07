package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.infrastructure.persistence.entity.ProductoEntity;
import org.luis.proyecto.infrastructure.persistence.entity.LaboratorioEntity;
import org.luis.proyecto.infrastructure.persistence.entity.FamiliaProductoEntity;
import org.luis.proyecto.infrastructure.persistence.entity.MonedaEntity;
import org.luis.proyecto.infrastructure.rest.request.ProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.ProductoResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public Producto toDomain(ProductoEntity entity) {
        if (entity == null) return null;
        Producto domain = new Producto();
        domain.setGrpAlmId(entity.getGrpAlmId());
        domain.setClsAlmId(entity.getClsAlmId());
        domain.setIteAlmId(entity.getIteAlmId());
        domain.setIteAlmCodBarra(entity.getIteAlmCodBarra());
        domain.setLabId(entity.getLaboratorio() != null ? entity.getLaboratorio().getId() : null);
        domain.setFamId(entity.getFamiliaProducto() != null ? entity.getFamiliaProducto().getId() : null);
        domain.setComGenId(entity.getComGenId());
        domain.setIteAlmDescDetalle(entity.getIteAlmDescDetalle());
        domain.setIteAlmDescResumen(entity.getIteAlmDescResumen());
        domain.setIteAlmUso(entity.getIteAlmUso());
        domain.setIteAlmUniMed(entity.getIteAlmUniMed());
        domain.setIteAlmCtaCompra(entity.getIteAlmCtaCompra());
        domain.setIteAlmCtaEntMat(entity.getIteAlmCtaEntMat());
        domain.setIteAlmCtaExist(entity.getIteAlmCtaExist());
        domain.setIteAlmPrecio(entity.getIteAlmPrecio());
        domain.setMonedaId(entity.getMoneda() != null ? entity.getMoneda().getId() : null);
        domain.setIteAlmUltFecAdq(entity.getIteAlmUltFecAdq());
        domain.setIteAlmEstado(entity.getIteAlmEstado());
        domain.setIteAlmFecBaja(entity.getIteAlmFecBaja());
        domain.setIteAlmStockMin(entity.getIteAlmStockMin());
        domain.setIteAlmTasIGV(entity.getIteAlmTasIGV());
        domain.setIteAlmTasISC(entity.getIteAlmTasISC());
        domain.setIteAlmControlado(entity.getIteAlmControlado());
        domain.setIteAlmFraccUni(entity.getIteAlmFraccUni());
        domain.setIteAlmCosPro(entity.getIteAlmCosPro());
        domain.setIteAlmDscto(entity.getIteAlmDscto());
        domain.setIteAlmDsctoAdi(entity.getIteAlmDsctoAdi());
        domain.setIteAlmUtilidadVta(entity.getIteAlmUtilidadVta());
        domain.setIteAlmUtilidadSug(entity.getIteAlmUtilidadSug());
        domain.setIteAlmPVPF(entity.getIteAlmPVPF());
        domain.setIteAlmPreVta(entity.getIteAlmPreVta());
        domain.setIteAlmValorVtaFar(entity.getIteAlmValorVtaFar());
        domain.setIteAlmFecVen(entity.getIteAlmFecVen());
        domain.setCodpro(entity.getCodpro());
        domain.setItemAlmCtrlAdm(entity.getItemAlmCtrlAdm());
        domain.setUnidMedId(entity.getUnidMedId());
        domain.setUsrSistema(entity.getUsrSistema());
        domain.setFecSistema(entity.getFecSistema());
        domain.setHrsSistema(entity.getHrsSistema());
        return domain;
    }

    public ProductoEntity toEntity(Producto domain) {
        if (domain == null) return null;
        ProductoEntity entity = new ProductoEntity();
        if (domain.getIteAlmId() != null) {
            entity.setIteAlmId(domain.getIteAlmId());
        }
        entity.setGrpAlmId(domain.getGrpAlmId());
        entity.setClsAlmId(domain.getClsAlmId());
        entity.setIteAlmCodBarra(domain.getIteAlmCodBarra());
        if (domain.getLabId() != null) {
            LaboratorioEntity lab = new LaboratorioEntity();
            lab.setId(domain.getLabId());
            entity.setLaboratorio(lab);
        }
        if (domain.getFamId() != null) {
            FamiliaProductoEntity fam = new FamiliaProductoEntity();
            fam.setId(domain.getFamId());
            entity.setFamiliaProducto(fam);
        }
        entity.setComGenId(domain.getComGenId());
        entity.setIteAlmDescDetalle(domain.getIteAlmDescDetalle());
        entity.setIteAlmDescResumen(domain.getIteAlmDescResumen());
        entity.setIteAlmUso(domain.getIteAlmUso());
        entity.setIteAlmUniMed(domain.getIteAlmUniMed());
        entity.setIteAlmCtaCompra(domain.getIteAlmCtaCompra());
        entity.setIteAlmCtaEntMat(domain.getIteAlmCtaEntMat());
        entity.setIteAlmCtaExist(domain.getIteAlmCtaExist());
        entity.setIteAlmPrecio(domain.getIteAlmPrecio());
        if (domain.getMonedaId() != null) {
            MonedaEntity mon = new MonedaEntity();
            mon.setId(domain.getMonedaId());
            entity.setMoneda(mon);
        }
        entity.setIteAlmUltFecAdq(domain.getIteAlmUltFecAdq());
        entity.setIteAlmEstado(domain.getIteAlmEstado());
        entity.setIteAlmFecBaja(domain.getIteAlmFecBaja());
        entity.setIteAlmStockMin(domain.getIteAlmStockMin());
        entity.setIteAlmTasIGV(domain.getIteAlmTasIGV());
        entity.setIteAlmTasISC(domain.getIteAlmTasISC());
        entity.setIteAlmControlado(domain.getIteAlmControlado());
        entity.setIteAlmFraccUni(domain.getIteAlmFraccUni());
        entity.setIteAlmCosPro(domain.getIteAlmCosPro());
        entity.setIteAlmDscto(domain.getIteAlmDscto());
        entity.setIteAlmDsctoAdi(domain.getIteAlmDsctoAdi());
        entity.setIteAlmUtilidadVta(domain.getIteAlmUtilidadVta());
        entity.setIteAlmUtilidadSug(domain.getIteAlmUtilidadSug());
        entity.setIteAlmPVPF(domain.getIteAlmPVPF());
        entity.setIteAlmPreVta(domain.getIteAlmPreVta());
        entity.setIteAlmValorVtaFar(domain.getIteAlmValorVtaFar());
        entity.setIteAlmFecVen(domain.getIteAlmFecVen());
        entity.setCodpro(domain.getCodpro());
        entity.setItemAlmCtrlAdm(domain.getItemAlmCtrlAdm());
        entity.setUnidMedId(domain.getUnidMedId());
        entity.setUsrSistema(domain.getUsrSistema());
        entity.setFecSistema(domain.getFecSistema());
        entity.setHrsSistema(domain.getHrsSistema());
        return entity;
    }

    public Producto toDomain(ProductoRequest request) {
        if (request == null) return null;
        Producto domain = new Producto();
        domain.setGrpAlmId(request.grpAlmId());
        domain.setClsAlmId(request.clsAlmId());
        domain.setIteAlmId(request.iteAlmId());
        domain.setIteAlmCodBarra(request.iteAlmCodBarra());
        domain.setLabId(request.labId());
        domain.setFamId(request.famId());
        domain.setComGenId(request.comGenId());
        domain.setIteAlmDescDetalle(request.iteAlmDescDetalle());
        domain.setIteAlmDescResumen(request.iteAlmDescResumen());
        domain.setIteAlmUso(request.iteAlmUso());
        domain.setIteAlmUniMed(request.iteAlmUniMed());
        domain.setIteAlmCtaCompra(request.iteAlmCtaCompra());
        domain.setIteAlmCtaEntMat(request.iteAlmCtaEntMat());
        domain.setIteAlmCtaExist(request.iteAlmCtaExist());
        domain.setIteAlmPrecio(request.iteAlmPrecio());
        domain.setMonedaId(request.monedaId());
        domain.setIteAlmUltFecAdq(request.iteAlmUltFecAdq());
        domain.setIteAlmEstado(request.iteAlmEstado());
        domain.setIteAlmFecBaja(request.iteAlmFecBaja());
        domain.setIteAlmStockMin(request.iteAlmStockMin());
        domain.setIteAlmTasIGV(request.iteAlmTasIGV());
        domain.setIteAlmTasISC(request.iteAlmTasISC());
        domain.setIteAlmControlado(request.iteAlmControlado());
        domain.setIteAlmFraccUni(request.iteAlmFraccUni());
        domain.setIteAlmCosPro(request.iteAlmCosPro());
        domain.setIteAlmDscto(request.iteAlmDscto());
        domain.setIteAlmDsctoAdi(request.iteAlmDsctoAdi());
        domain.setIteAlmUtilidadVta(request.iteAlmUtilidadVta());
        domain.setIteAlmUtilidadSug(request.iteAlmUtilidadSug());
        domain.setIteAlmPVPF(request.iteAlmPVPF());
        domain.setIteAlmPreVta(request.iteAlmPreVta());
        domain.setIteAlmValorVtaFar(request.iteAlmValorVtaFar());
        domain.setIteAlmFecVen(request.iteAlmFecVen());
        domain.setCodpro(request.codpro());
        domain.setItemAlmCtrlAdm(request.itemAlmCtrlAdm());
        domain.setUnidMedId(request.unidMedId());
        domain.setUsrSistema(request.usrSistema());
        domain.setFecSistema(request.fecSistema());
        domain.setHrsSistema(request.hrsSistema());
        return domain;
    }

    public ProductoResponse toResponse(Producto domain) {
        if (domain == null) {
            return null;
        }

        return new ProductoResponse(
                domain.getGrpAlmId(),
                domain.getClsAlmId(),
                domain.getIteAlmId(),
                domain.getIteAlmCodBarra(),
                domain.getLabId(),
                domain.getFamId(),
                domain.getComGenId(),
                domain.getIteAlmDescDetalle(),
                domain.getIteAlmDescResumen(),
                domain.getIteAlmUso(),
                domain.getIteAlmUniMed(),
                domain.getIteAlmCtaCompra(),
                domain.getIteAlmCtaEntMat(),
                domain.getIteAlmCtaExist(),
                domain.getIteAlmPrecio(),
                domain.getMonedaId(),
                domain.getIteAlmUltFecAdq(),
                domain.getIteAlmEstado(),
                domain.getIteAlmFecBaja(),
                domain.getIteAlmStockMin(),
                domain.getIteAlmTasIGV(),
                domain.getIteAlmTasISC(),
                domain.getIteAlmControlado(),
                domain.getIteAlmFraccUni(),
                domain.getIteAlmCosPro(),
                domain.getIteAlmDscto(),
                domain.getIteAlmDsctoAdi(),
                domain.getIteAlmUtilidadVta(),
                domain.getIteAlmUtilidadSug(),
                domain.getIteAlmPVPF(),
                domain.getIteAlmPreVta(),
                domain.getIteAlmValorVtaFar(),
                domain.getIteAlmFecVen(),
                domain.getCodpro(),
                domain.getItemAlmCtrlAdm(),
                domain.getUnidMedId(),
                domain.getUsrSistema(),
                domain.getFecSistema(),
                domain.getHrsSistema()
        );
    }
}