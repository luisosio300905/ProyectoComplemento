package org.luis.proyecto.application.service.tipocomprobantepago.impl;

import org.luis.proyecto.application.service.tipocomprobantepago.TipoComprobantePagoService;
import org.luis.proyecto.application.usecase.tipocomprobantepago.*;
import org.luis.proyecto.domain.model.TipoComprobantePago;
import java.util.List;

public class TipoComprobantePagoServiceImpl implements TipoComprobantePagoService {
    private final CrearTipoComprobantePagoUseCase crearTipoComprobantePagoUseCase;
    private final ActualizarTipoComprobantePagoUseCase actualizarTipoComprobantePagoUseCase;
    private final EliminarTipoComprobantePagoUseCase eliminarTipoComprobantePagoUseCase;
    private final ListaTipoComprobantePagosUseCase listaTipoComprobantePagoUseCase;
    private final ObtenerTipoComprobantePagoUseCase obtenerTipoComprobantePagoUseCase;

    public TipoComprobantePagoServiceImpl(
            CrearTipoComprobantePagoUseCase crearTipoComprobantePagoUseCase,
            ActualizarTipoComprobantePagoUseCase actualizarTipoComprobantePagoUseCase,
            EliminarTipoComprobantePagoUseCase eliminarTipoComprobantePagoUseCase,
            ListaTipoComprobantePagosUseCase listaTipoComprobantePagoUseCase,
            ObtenerTipoComprobantePagoUseCase obtenerTipoComprobantePagoUseCase) {
        this.crearTipoComprobantePagoUseCase = crearTipoComprobantePagoUseCase;
        this.actualizarTipoComprobantePagoUseCase = actualizarTipoComprobantePagoUseCase;
        this.eliminarTipoComprobantePagoUseCase = eliminarTipoComprobantePagoUseCase;
        this.listaTipoComprobantePagoUseCase = listaTipoComprobantePagoUseCase;
        this.obtenerTipoComprobantePagoUseCase = obtenerTipoComprobantePagoUseCase;
    }

    @Override
    public TipoComprobantePago crear(TipoComprobantePago tipoComprobantePago) {
        return crearTipoComprobantePagoUseCase.crear(tipoComprobantePago);
    }

    @Override
    public TipoComprobantePago actualizar(Integer id, TipoComprobantePago tipoComprobantePago) {
        return actualizarTipoComprobantePagoUseCase.actualizar(id, tipoComprobantePago);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarTipoComprobantePagoUseCase.eliminar(id);
    }

    @Override
    public TipoComprobantePago obtenerTipoComprobantePago(Integer id) {
        return obtenerTipoComprobantePagoUseCase.obtener(id);
    }

    @Override
    public List<TipoComprobantePago> obtenerTodos() {
        return listaTipoComprobantePagoUseCase.listar();
    }
}