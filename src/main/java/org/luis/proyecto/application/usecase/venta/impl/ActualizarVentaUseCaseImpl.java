package org.luis.proyecto.application.usecase.venta.impl;
import org.luis.proyecto.application.usecase.venta.ActualizarVentaUseCase;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.domain.repository.VentaRepository;
public class ActualizarVentaUseCaseImpl implements ActualizarVentaUseCase{
    private final VentaRepository ventaRepository;
    public ActualizarVentaUseCaseImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }
    @Override
    public Venta actualizar(Integer id, Venta venta) {
        Venta ventaActualizar = ventaRepository.findById(id).orElseThrow();
        actualizarVenta(ventaActualizar, venta);
        return ventaRepository.save(ventaActualizar);
    }
    private void actualizarVenta(Venta venta1, Venta venta2) {
        venta1.setEmpresaId(venta2.getEmpresaId());
        venta1.setUnidComId(venta2.getUnidComId());
        venta1.setDocId(venta2.getDocId());
        venta1.setVtaCabNumComp(venta2.getVtaCabNumComp());
        venta1.setClienId(venta2.getClienId());
        venta1.setMonedaId(venta2.getMonedaId());
        venta1.setVtaCabFecha(venta2.getVtaCabFecha());
        venta1.setVtaValCamb(venta2.getVtaValCamb());
        venta1.setVtaCabAccImp(venta2.getVtaCabAccImp());
        venta1.setVtaComAccAnu(venta2.getVtaComAccAnu());
        venta1.setCondComId(venta2.getCondComId());
        venta1.setVtaCabEstCanc(venta2.getVtaCabEstCanc());
        venta1.setVtaCabCierre(venta2.getVtaCabCierre());
        venta1.setVtaCabActPlla(venta2.getVtaCabActPlla());
        venta1.setVtaCabAfecDetrac(venta2.getVtaCabAfecDetrac());
        venta1.setVtaCabContDetrac(venta2.getVtaCabContDetrac());
        venta1.setTipOpeComId(venta2.getTipOpeComId());
        venta1.setVtaCabNumRef(venta2.getVtaCabNumRef());
        venta1.setVtaCabValorVta(venta2.getVtaCabValorVta());
        venta1.setVtaCabValorVtaExo(venta2.getVtaCabValorVtaExo());
        venta1.setVtaCabValIGV(venta2.getVtaCabValIGV());
        venta1.setVtaCabValISC(venta2.getVtaCabValISC());
        venta1.setVtaCabValTotal(venta2.getVtaCabValTotal());
        venta1.setVtaCabValMonPago(venta2.getVtaCabValMonPago());
        venta1.setVtaCabValVuelto(venta2.getVtaCabValVuelto());
        venta1.setVtaCabNamePaciente(venta2.getVtaCabNamePaciente());
        venta1.setUsrSistema(venta2.getUsrSistema());
        venta1.setFecSistema(venta2.getFecSistema());
        venta1.setHrsSistema(venta2.getHrsSistema());
        venta1.setVtaCabDsctoGlobal(venta2.getVtaCabDsctoGlobal());
        venta1.setVtaCabFechaVcto(venta2.getVtaCabFechaVcto());
        venta1.setDetallesVenta(venta2.getDetallesVenta());
    }
}