package org.luis.proyecto.application.service.detalleventa.impl;

import org.luis.proyecto.application.service.detalleventa.DetalleVentaService;
import org.luis.proyecto.application.usecase.detalleventa.*;
import org.luis.proyecto.domain.model.DetalleVenta;
import java.util.List;

public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final ActualizarDetalleVentaUseCase actualizarDetalleVentaUseCase;
    private final CrearDetalleVentaUseCase crearDetalleVentaUseCase;
    private final EliminarDetalleVentaUseCase eliminarDetalleVentaUseCase;
    private final ListaDetalleVentaUseCase listaDetalleVentaUseCase;
    private final ObtenerDetalleVentaUseCase obtenerDetalleVentaUseCase;

    public DetalleVentaServiceImpl(ActualizarDetalleVentaUseCase actualizarDetalleVentaUseCase,
                                   CrearDetalleVentaUseCase crearDetalleVentaUseCase,
                                   EliminarDetalleVentaUseCase eliminarDetalleVentaUseCase,
                                   ListaDetalleVentaUseCase listaDetalleVentaUseCase,
                                   ObtenerDetalleVentaUseCase obtenerDetalleVentaUseCase) {
        this.actualizarDetalleVentaUseCase = actualizarDetalleVentaUseCase;
        this.crearDetalleVentaUseCase = crearDetalleVentaUseCase;
        this.eliminarDetalleVentaUseCase = eliminarDetalleVentaUseCase;
        this.listaDetalleVentaUseCase = listaDetalleVentaUseCase;
        this.obtenerDetalleVentaUseCase = obtenerDetalleVentaUseCase;
    }

    @Override
    public DetalleVenta crear(DetalleVenta detalleVenta) {
        return crearDetalleVentaUseCase.crear(detalleVenta);
    }

    @Override
    public DetalleVenta actualizar(Integer id, DetalleVenta detalleVenta) {
        return actualizarDetalleVentaUseCase.actualizar(id, detalleVenta);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarDetalleVentaUseCase.eliminar(id);
    }

    @Override
    public DetalleVenta obtenerDetalleVenta(Integer id) {
        return obtenerDetalleVentaUseCase.obtenerDetalleVenta(id);
    }

    @Override
    public List<DetalleVenta> obtenerTodos() { // Ya no dará error al tener el import java.util.List
        return listaDetalleVentaUseCase.obtenerTodos();
    }
}
