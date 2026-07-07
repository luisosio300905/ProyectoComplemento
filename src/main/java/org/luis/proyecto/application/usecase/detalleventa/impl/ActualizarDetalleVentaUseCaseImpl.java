package org.luis.proyecto.application.usecase.detalleventa.impl;
import org.luis.proyecto.application.usecase.detalleventa.ActualizarDetalleVentaUseCase;
import org.luis.proyecto.domain.model.DetalleVenta;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;

public class ActualizarDetalleVentaUseCaseImpl implements ActualizarDetalleVentaUseCase {
    private final DetalleVentaRepository detalleVentaRepository;
    public ActualizarDetalleVentaUseCaseImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }
    @Override
    public DetalleVenta actualizar(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta actualizar = detalleVentaRepository.findById(id).orElseThrow();
        actualizar.setVenta(detalleVenta.getVenta());
        actualizar.setEmpresaId(detalleVenta.getEmpresaId());
        actualizar.setUnidComId(detalleVenta.getUnidComId());
        actualizar.setDocId(detalleVenta.getDocId());
        actualizar.setVtaCabNumComp(detalleVenta.getVtaCabNumComp());
        actualizar.setVtaDetCodref(detalleVenta.getVtaDetCodref());
        actualizar.setVtaDetItem(detalleVenta.getVtaDetItem());
        actualizar.setVtaDetCantidad(detalleVenta.getVtaDetCantidad());
        actualizar.setVtaDetPrecUnit(detalleVenta.getVtaDetPrecUnit());
        actualizar.setVtaDetValorVta(detalleVenta.getVtaDetValorVta());
        actualizar.setVtaDetValIGV(detalleVenta.getVtaDetValIGV());
        actualizar.setVtaDetValISC(detalleVenta.getVtaDetValISC());
        actualizar.setVtaDetValTot(detalleVenta.getVtaDetValTot());
        actualizar.setTipVtaId(detalleVenta.getTipVtaId());
        actualizar.setTipAlmId(detalleVenta.getTipAlmId());
        actualizar.setAlmacenId(detalleVenta.getAlmacenId());
        actualizar.setVtaDetFracUni(detalleVenta.getVtaDetFracUni());
        actualizar.setVtaDetCantFrac(detalleVenta.getVtaDetCantFrac());
        actualizar.setUsrSistema(detalleVenta.getUsrSistema());
        actualizar.setFecSistema(detalleVenta.getFecSistema());
        actualizar.setHrsSistema(detalleVenta.getHrsSistema());
        actualizar.setVtaDetValIna(detalleVenta.getVtaDetValIna());

        return detalleVentaRepository.save(actualizar);
    }
}