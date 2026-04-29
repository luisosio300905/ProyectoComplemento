package org.luis.proyecto.application.service.comprobantepago.impl;

import org.luis.proyecto.application.service.comprobantepago.ComprobantePagoService;
import org.luis.proyecto.application.usecase.comprobantepago.*;
import org.luis.proyecto.domain.model.ComprobantePago;

import java.util.List;

public class ComprobantePagoServiceImpl implements ComprobantePagoService {
    private final ActualizarComprobantePagoUseCase actualizarComprobantePagoUseCase;
    private final CrearComprobantePagoUseCase crearComprobantePagoUseCase;
    private final EliminarComprobantePagoUseCase eliminarComprobantePagoUseCase;
    private final ListaComprobantePagoUseCase listaComprobantePagoUseCase;
    private final ObtenerComprobantePagoUseCase obtenerComprobantePagoUseCase;

    public ComprobantePagoServiceImpl(ActualizarComprobantePagoUseCase actualizarComprobantePagoUseCase, CrearComprobantePagoUseCase crearComprobantePagoUseCase, EliminarComprobantePagoUseCase eliminarComprobantePagoUseCase, ListaComprobantePagoUseCase listaComprobantePagoUseCase, ObtenerComprobantePagoUseCase obtenerComprobantePagoUseCase) {
        this.actualizarComprobantePagoUseCase = actualizarComprobantePagoUseCase;
        this.crearComprobantePagoUseCase = crearComprobantePagoUseCase;
        this.eliminarComprobantePagoUseCase = eliminarComprobantePagoUseCase;
        this.listaComprobantePagoUseCase = listaComprobantePagoUseCase;
        this.obtenerComprobantePagoUseCase = obtenerComprobantePagoUseCase;
    }


    @Override
    public ComprobantePago crear(ComprobantePago comprobantePago) {
        return crearComprobantePagoUseCase.crear(comprobantePago);
    }

    @Override
    public ComprobantePago actualizar(Integer id, ComprobantePago comprobantePago) {
        return actualizarComprobantePagoUseCase.actualizar(id, comprobantePago);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarComprobantePagoUseCase.eliminar(id);
    }

    @Override
    public ComprobantePago obtenerComprobantePago(Integer id) {
        return obtenerComprobantePagoUseCase.obtenerComprobantePago(id);
    }

    @Override
    public List<ComprobantePago> obtenerTodos() {
        return listaComprobantePagoUseCase.obtenerTodos();
    }
}
