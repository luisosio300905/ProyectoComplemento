package org.luis.proyecto.application.service.venta.impl;

import java.util.List;

import org.luis.proyecto.application.service.venta.VentaService;
import org.luis.proyecto.application.usecase.venta.ActualizarVentaUseCase;
import org.luis.proyecto.application.usecase.venta.CrearVentaUseCase;
import org.luis.proyecto.application.usecase.venta.EliminarVentaUseCase;
import org.luis.proyecto.application.usecase.venta.ListaVentaUseCase;
import org.luis.proyecto.application.usecase.venta.ObtenerVentaUseCase;
import org.luis.proyecto.application.usecase.venta.impl.CrearVentaUseCaseImpl;
import org.luis.proyecto.application.service.balancegeneral.BalanceGeneralService;
import org.luis.proyecto.domain.model.Venta;
import org.luis.proyecto.infrastructure.rest.response.VentaConBalanceResponse;
import org.luis.proyecto.infrastructure.rest.response.BalanceGeneralResponse;

public class VentaServiceImpl implements VentaService{
    private final CrearVentaUseCase crearVentaUseCase;
    private final ActualizarVentaUseCase actualizarVentaUseCase;
    private final EliminarVentaUseCase eliminarVentaUseCase;
    private final ListaVentaUseCase listaVentaUseCase;
    private final ObtenerVentaUseCase obtenerVentaUseCase;
    private final BalanceGeneralService balanceGeneralService;

    public VentaServiceImpl(CrearVentaUseCase crearVentaUseCase, ActualizarVentaUseCase actualizarVentaUseCase, EliminarVentaUseCase eliminarVentaUseCase, ListaVentaUseCase listaVentaUseCase, ObtenerVentaUseCase obtenerVentaUseCase) {
        this.crearVentaUseCase = crearVentaUseCase;
        this.actualizarVentaUseCase = actualizarVentaUseCase;
        this.eliminarVentaUseCase = eliminarVentaUseCase;
        this.listaVentaUseCase = listaVentaUseCase;
        this.obtenerVentaUseCase = obtenerVentaUseCase;
        this.balanceGeneralService = null;  // Inyectado opcionalmente
    }

    public VentaServiceImpl(CrearVentaUseCase crearVentaUseCase, ActualizarVentaUseCase actualizarVentaUseCase, EliminarVentaUseCase eliminarVentaUseCase, ListaVentaUseCase listaVentaUseCase, ObtenerVentaUseCase obtenerVentaUseCase, BalanceGeneralService balanceGeneralService) {
        this.crearVentaUseCase = crearVentaUseCase;
        this.actualizarVentaUseCase = actualizarVentaUseCase;
        this.eliminarVentaUseCase = eliminarVentaUseCase;
        this.listaVentaUseCase = listaVentaUseCase;
        this.obtenerVentaUseCase = obtenerVentaUseCase;
        this.balanceGeneralService = balanceGeneralService;
    }

    @Override
    public Venta crear(Venta venta) {
        return crearVentaUseCase.crear(venta);
    }

    @Override
    public VentaConBalanceResponse crearConBalance(Venta venta) {
        // Crear la venta (internamente crea el asiento contable)
        Venta ventaCreada = crearVentaUseCase.crear(venta);

        // Obtener el ID de la cabecera creada desde el ThreadLocal
        Long diaCabCompId = CrearVentaUseCaseImpl.obtenerUltimaDiaCabCompId();

        VentaConBalanceResponse respuesta = null;
        if (diaCabCompId != null && balanceGeneralService != null) {
            // Obtener el balance general del asiento creado
            BalanceGeneralResponse balance = balanceGeneralService.obtenerBalance(diaCabCompId);
            respuesta = new VentaConBalanceResponse(
                ventaCreada.getId(),
                ventaCreada.getVtaCabNumComp(),
                ventaCreada.getVtaCabValTotal(),
                diaCabCompId,
                balance != null ? balance.getTotalDebe() : null,
                balance != null ? balance.getTotalHaber() : null
            );
        } else {
            // Si no disponemos del balance, devolver respuesta con nulls
            respuesta = new VentaConBalanceResponse(
                ventaCreada.getId(),
                ventaCreada.getVtaCabNumComp(),
                ventaCreada.getVtaCabValTotal(),
                diaCabCompId,
                null,
                null
            );
        }

        // Limpiar el ThreadLocal
        CrearVentaUseCaseImpl.limpiarUltimaDiaCabCompId();

        return respuesta;
    }

    @Override
    public Venta actualizar(Integer id, Venta venta) {
        return actualizarVentaUseCase.actualizar(id, venta);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarVentaUseCase.eliminar(id);
    }

    @Override
    public Venta obtenerVenta(Integer id) {
        return obtenerVentaUseCase.obtenerVenta(id);
    }

    @Override
    public List<Venta> obtenerTodos() {
        return listaVentaUseCase.obtenerTodos();
    }
}
