package org.luis.proyecto.application.service.venta.impl;

import java.util.List;

import org.luis.proyecto.application.service.venta.VentaService;
import org.luis.proyecto.application.usecase.venta.ActualizarVentaUseCase;
import org.luis.proyecto.application.usecase.venta.CrearVentaUseCase;
import org.luis.proyecto.application.usecase.venta.EliminarVentaUseCase;
import org.luis.proyecto.application.usecase.venta.ListaVentaUseCase;
import org.luis.proyecto.application.usecase.venta.ObtenerVentaUseCase;
import org.luis.proyecto.domain.model.Venta;

public class VentaServiceImpl implements VentaService{
    private final CrearVentaUseCase crearVentaUseCase;
    private final ActualizarVentaUseCase actualizarVentaUseCase;
    private final EliminarVentaUseCase eliminarVentaUseCase;
    private final ListaVentaUseCase listaVentaUseCase;
    private final ObtenerVentaUseCase obtenerVentaUseCase;

    public VentaServiceImpl(CrearVentaUseCase crearVentaUseCase, ActualizarVentaUseCase actualizarVentaUseCase, EliminarVentaUseCase eliminarVentaUseCase, ListaVentaUseCase listaVentaUseCase, ObtenerVentaUseCase obtenerVentaUseCase) {
        this.crearVentaUseCase = crearVentaUseCase;
        this.actualizarVentaUseCase = actualizarVentaUseCase;
        this.eliminarVentaUseCase = eliminarVentaUseCase;
        this.listaVentaUseCase = listaVentaUseCase;
        this.obtenerVentaUseCase = obtenerVentaUseCase;
    }

    @Override
    public Venta crear(Venta venta) {
        return crearVentaUseCase.crear(venta);
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
