package org.luis.proyecto.application.service.compra.impl;

import org.luis.proyecto.application.service.compra.CompraService;
import org.luis.proyecto.application.usecase.compra.*;
import org.luis.proyecto.domain.model.Compra;

import java.util.List;

public class CompraServiceImpl implements CompraService {
    private final CrearCompraUseCase crearCompraUseCase;
    private final ActualizarCompraUseCase actualizarCompraUseCase;
    private final EliminarCompraUseCase eliminarCompraUseCase;
    private final ListaComprasUseCase listaComprasUseCase;
    private final ObtenerCompraUseCase obtenerCompraUseCase;

    public CompraServiceImpl(
            CrearCompraUseCase crearCompraUseCase,
            ActualizarCompraUseCase actualizarCompraUseCase,
            EliminarCompraUseCase eliminarCompraUseCase,
            ListaComprasUseCase listaComprasUseCase,
            ObtenerCompraUseCase obtenerCompraUseCase
    ) {
        this.crearCompraUseCase = crearCompraUseCase;
        this.actualizarCompraUseCase = actualizarCompraUseCase;
        this.eliminarCompraUseCase = eliminarCompraUseCase;
        this.listaComprasUseCase = listaComprasUseCase;
        this.obtenerCompraUseCase = obtenerCompraUseCase;
    }

    @Override
    public Compra crear(Compra compra) {
        return crearCompraUseCase.crear(compra);
    }

    @Override
    public Compra actualizar(Integer id, Compra compra) {
        return actualizarCompraUseCase.actualizar(id, compra);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarCompraUseCase.eliminar(id);
    }

    @Override
    public Compra obtenerCompra(Integer id) {
        return obtenerCompraUseCase.obtenerCompra(id);
    }

    @Override
    public List<Compra> obtenerTodas() {
        return listaComprasUseCase.obtenerTodas();
    }
}

