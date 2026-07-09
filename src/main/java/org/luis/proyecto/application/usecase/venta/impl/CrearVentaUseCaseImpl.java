package org.luis.proyecto.application.usecase.venta.impl;

import org.luis.proyecto.application.service.mapeocuentas.MapeoVentaCuentasService;
import org.luis.proyecto.application.usecase.diariocabecera.CrearDiarioCabeceraUseCase;
import org.luis.proyecto.application.usecase.diariodetalle.CrearDiarioDetalleUseCase;
import org.luis.proyecto.application.usecase.venta.CrearVentaUseCase;
import org.luis.proyecto.domain.model.DiarioCabecera;
import org.luis.proyecto.domain.model.DiarioDetalle;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.domain.repository.VentaRepository;

import java.time.LocalDateTime;
import java.util.List;

public class CrearVentaUseCaseImpl implements CrearVentaUseCase {
    private final VentaRepository ventaRepository;
    private final CrearDiarioCabeceraUseCase crearDiarioCabeceraUseCase;
    private final CrearDiarioDetalleUseCase crearDiarioDetalleUseCase;
    private final MapeoVentaCuentasService mapeoVentaCuentasService;

    public CrearVentaUseCaseImpl(VentaRepository ventaRepository,
                                 CrearDiarioCabeceraUseCase crearDiarioCabeceraUseCase,
                                 CrearDiarioDetalleUseCase crearDiarioDetalleUseCase,
                                 MapeoVentaCuentasService mapeoVentaCuentasService) {
        this.ventaRepository = ventaRepository;
        this.crearDiarioCabeceraUseCase = crearDiarioCabeceraUseCase;
        this.crearDiarioDetalleUseCase = crearDiarioDetalleUseCase;
        this.mapeoVentaCuentasService = mapeoVentaCuentasService;
    }

    @Override
    public Venta crear(Venta venta) {
        Venta ventaGuardada = ventaRepository.save(venta);

        LocalDateTime fechaAsiento = ventaGuardada.getVtaCabFecha() != null
                ? ventaGuardada.getVtaCabFecha()
                : LocalDateTime.now();

        DiarioCabecera cab = new DiarioCabecera();
        cab.setEmpresaId(ventaGuardada.getEmpresaId());
        cab.setDiaCabFec(fechaAsiento);
        cab.setDiaCabAno(fechaAsiento.getYear());
        cab.setDiaCabMes(fechaAsiento.getMonthValue());
        cab.setDiaCabGlosa("Asiento por venta: " + ventaGuardada.getVtaCabNumComp());
        cab.setUsrSistema(ventaGuardada.getUsrSistema());
        cab.setFecSistema(LocalDateTime.now());

        DiarioCabecera cabCreada = crearDiarioCabeceraUseCase.crear(cab);

        String usuario = ventaGuardada.getUsrSistema() != null ? ventaGuardada.getUsrSistema() : "SISTEMA";
        List<DiarioDetalle> lineas = mapeoVentaCuentasService.construirAsientoVenta(ventaGuardada, usuario);

        for (DiarioDetalle linea : lineas) {
            linea.setDiaCabCompId(cabCreada.getDiaCabCompId());
            crearDiarioDetalleUseCase.crear(linea);
        }

        ventaGuardada.setDiaCabCompId(cabCreada.getDiaCabCompId());
        return ventaGuardada;
    }
}
