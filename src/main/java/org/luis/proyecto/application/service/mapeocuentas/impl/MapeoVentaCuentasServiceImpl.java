package org.luis.proyecto.application.service.mapeocuentas.impl;

import org.luis.proyecto.application.service.mapeocuentas.MapeoVentaCuentasService;
import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.model.Venta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Plan contable general empresarial (PCGE) – Perú.
 * Asiento típico de venta gravada con IGV (18%):
 * <ul>
 *   <li>DEBE  12.1212 – Facturas por cobrar (total con IGV)</li>
 *   <li>HABER 70.7011 – Ventas de mercaderías (base imponible)</li>
 *   <li>HABER 40.4011 – IGV – Cuenta propia</li>
 * </ul>
 */
public class MapeoVentaCuentasServiceImpl implements MapeoVentaCuentasService {

    private static final BigDecimal TASA_IGV = new BigDecimal("0.18");
    private static final BigDecimal FACTOR_IGV = new BigDecimal("1.18");

    // Elementos PCGE
    private static final String CUENTA_CXC = "12";
    private static final String SUB_CXC_FACTURAS = "1212";
    private static final String CUENTA_VENTAS = "70";
    private static final String SUB_VENTAS_MERCADERIAS = "7011";
    private static final String CUENTA_TRIBUTOS = "40";
    private static final String SUB_IGV = "4011";

    @Override
    public List<DiarioDetalle> construirAsientoVenta(Venta venta, String usuario) {
        BigDecimal total = nvl(venta.getVtaCabValTotal());
        BigDecimal baseImponible = calcularBaseImponible(venta, total);
        BigDecimal igv = calcularIgv(venta, total, baseImponible);

        String monedaId = venta.getMonedaId() != null ? venta.getMonedaId().toString() : "1";
        String numComprobante = venta.getVtaCabNumComp();
        String usr = usuario != null ? usuario : "SISTEMA";

        List<DiarioDetalle> lineas = new ArrayList<>();

        // DEBE: Cuentas por cobrar (total con IGV)
        lineas.add(crearLinea(
                total, BigDecimal.ZERO,
                CUENTA_CXC, SUB_CXC_FACTURAS, null, null,
                "Debe - CxC venta " + numComprobante,
                numComprobante, monedaId, usr
        ));

        // HABER: Ventas (base imponible)
        if (baseImponible.compareTo(BigDecimal.ZERO) > 0) {
            lineas.add(crearLinea(
                    BigDecimal.ZERO, baseImponible,
                    CUENTA_VENTAS, SUB_VENTAS_MERCADERIAS, null, null,
                    "Haber - Ventas " + numComprobante,
                    numComprobante, monedaId, usr
            ));
        }

        // HABER: IGV por pagar
        if (igv.compareTo(BigDecimal.ZERO) > 0) {
            lineas.add(crearLinea(
                    BigDecimal.ZERO, igv,
                    CUENTA_TRIBUTOS, SUB_IGV, null, null,
                    "Haber - IGV venta " + numComprobante,
                    numComprobante, monedaId, usr
            ));
        }

        return lineas;
    }

    private BigDecimal calcularBaseImponible(Venta venta, BigDecimal total) {
        if (venta.getVtaCabValorVta() != null) {
            return venta.getVtaCabValorVta();
        }
        if (venta.getVtaCabValIGV() != null) {
            return total.subtract(venta.getVtaCabValIGV());
        }
        if (total.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return total.divide(FACTOR_IGV, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal calcularIgv(Venta venta, BigDecimal total, BigDecimal baseImponible) {
        if (venta.getVtaCabValIGV() != null) {
            return venta.getVtaCabValIGV();
        }
        if (venta.getVtaCabValorVta() != null) {
            return total.subtract(baseImponible);
        }
        if (total.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return baseImponible.multiply(TASA_IGV).setScale(2, RoundingMode.HALF_UP);
    }

    private DiarioDetalle crearLinea(BigDecimal debe, BigDecimal haber,
                                     String cuentaId, String subCtaId,
                                     String divisioId, String subDivId,
                                     String descripcion, String numDoc,
                                     String monedaId, String usuario) {
        DiarioDetalle detalle = new DiarioDetalle();
        detalle.setCuentaId(cuentaId);
        detalle.setSubCtaId(subCtaId);
        detalle.setDivisioId(divisioId);
        detalle.setSubDivId(subDivId);
        detalle.setDiaDetDebe(debe);
        detalle.setDiaDetHaber(haber);
        detalle.setDiaDetTexOpe(descripcion);
        detalle.setDiaDetNumDoc(numDoc);
        detalle.setMonedaId(monedaId);
        detalle.setUsrSistema(usuario);
        detalle.setFecSistema(LocalDateTime.now());
        return detalle;
    }

    private BigDecimal nvl(BigDecimal valor) {
        return valor != null ? valor : BigDecimal.ZERO;
    }
}
