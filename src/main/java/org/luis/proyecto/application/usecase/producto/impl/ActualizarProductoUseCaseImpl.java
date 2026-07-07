package org.luis.proyecto.application.usecase.producto.impl;
import org.luis.proyecto.application.usecase.producto.ActualizarProductoUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;
@Service
public class ActualizarProductoUseCaseImpl implements ActualizarProductoUseCase {
    private final ProductoRepository productoRepository;
    public ActualizarProductoUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public Producto actualizar(Integer id, Producto producto) {
        Producto existente = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id " + id));
        existente.setGrpAlmId(producto.getGrpAlmId());
        existente.setClsAlmId(producto.getClsAlmId());
        existente.setIteAlmId(producto.getIteAlmId());
        existente.setIteAlmCodBarra(producto.getIteAlmCodBarra());
        existente.setLabId(producto.getLabId());
        existente.setFamId(producto.getFamId());
        existente.setComGenId(producto.getComGenId());
        existente.setIteAlmDescDetalle(producto.getIteAlmDescDetalle());
        existente.setIteAlmDescResumen(producto.getIteAlmDescResumen());
        existente.setIteAlmUso(producto.getIteAlmUso());
        existente.setIteAlmUniMed(producto.getIteAlmUniMed());
        existente.setIteAlmCtaCompra(producto.getIteAlmCtaCompra());
        existente.setIteAlmCtaEntMat(producto.getIteAlmCtaEntMat());
        existente.setIteAlmCtaExist(producto.getIteAlmCtaExist());
        existente.setIteAlmPrecio(producto.getIteAlmPrecio());
        existente.setMonedaId(producto.getMonedaId());
        existente.setIteAlmUltFecAdq(producto.getIteAlmUltFecAdq());
        existente.setIteAlmEstado(producto.getIteAlmEstado());
        existente.setIteAlmFecBaja(producto.getIteAlmFecBaja());
        existente.setIteAlmStockMin(producto.getIteAlmStockMin());
        existente.setIteAlmTasIGV(producto.getIteAlmTasIGV());
        existente.setIteAlmTasISC(producto.getIteAlmTasISC());
        existente.setIteAlmControlado(producto.getIteAlmControlado());
        existente.setIteAlmFraccUni(producto.getIteAlmFraccUni());
        existente.setIteAlmCosPro(producto.getIteAlmCosPro());
        existente.setIteAlmDscto(producto.getIteAlmDscto());
        existente.setIteAlmDsctoAdi(producto.getIteAlmDsctoAdi());
        existente.setIteAlmUtilidadVta(producto.getIteAlmUtilidadVta());
        existente.setIteAlmUtilidadSug(producto.getIteAlmUtilidadSug());
        existente.setIteAlmPVPF(producto.getIteAlmPVPF());
        existente.setIteAlmPreVta(producto.getIteAlmPreVta());
        existente.setIteAlmValorVtaFar(producto.getIteAlmValorVtaFar());
        existente.setIteAlmFecVen(producto.getIteAlmFecVen());
        existente.setCodpro(producto.getCodpro());
        existente.setItemAlmCtrlAdm(producto.getItemAlmCtrlAdm());
        existente.setUnidMedId(producto.getUnidMedId());
        existente.setUsrSistema(producto.getUsrSistema());
        existente.setFecSistema(producto.getFecSistema());
        existente.setHrsSistema(producto.getHrsSistema());

        return productoRepository.save(existente);
    }
}
