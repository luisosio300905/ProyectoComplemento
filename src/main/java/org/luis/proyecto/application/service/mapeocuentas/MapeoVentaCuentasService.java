package org.luis.proyecto.application.service.mapeocuentas;

import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.model.Venta;

import java.util.List;

/**
 * Traduce una venta a las líneas de un asiento contable, aplicando el plan contable
 * típico peruano (PCGE):
 * <ul>
 *     <li>DEBE  12 Cuentas por cobrar comerciales - Terceros (total con IGV)</li>
 *     <li>HABER 70 Ventas (valor de venta / base imponible)</li>
 *     <li>HABER 40 IGV por pagar (impuesto)</li>
 * </ul>
 * Las líneas devueltas quedan balanceadas (total debe = total haber) y aún no tienen
 * asignado el {@code diaCabCompId}; el caso de uso lo completa tras crear la cabecera.
 */
public interface MapeoVentaCuentasService {
    List<DiarioDetalle> construirAsientoVenta(Venta venta, String usuario);
}
