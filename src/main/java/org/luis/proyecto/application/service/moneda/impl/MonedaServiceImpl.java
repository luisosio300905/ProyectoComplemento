package org.luis.proyecto.application.service.moneda.impl;

import org.luis.proyecto.application.service.moneda.MonedaService;
import org.luis.proyecto.application.usecase.moneda.*;
import org.luis.proyecto.domain.model.Moneda;
import java.util.List;
import java.util.Optional;

public class MonedaServiceImpl implements MonedaService {

    private final CrearMonedaUseCase crearMonedaUseCase;
    private final ActualizarMonedaUseCase actualizarMonedaUseCase;
    private final EliminarMonedaUseCase eliminarMonedaUseCase;
    private final ObtenerMonedaUseCase obtenerMonedaUseCase;
    private final ListarMonedasUseCase listarMonedasUseCase;

    public MonedaServiceImpl(CrearMonedaUseCase crearMonedaUseCase,
                             ActualizarMonedaUseCase actualizarMonedaUseCase,
                             EliminarMonedaUseCase eliminarMonedaUseCase,
                             ObtenerMonedaUseCase obtenerMonedaUseCase,
                             ListarMonedasUseCase listarMonedasUseCase) {
        this.crearMonedaUseCase = crearMonedaUseCase;
        this.actualizarMonedaUseCase = actualizarMonedaUseCase;
        this.eliminarMonedaUseCase = eliminarMonedaUseCase;
        this.obtenerMonedaUseCase = obtenerMonedaUseCase;
        this.listarMonedasUseCase = listarMonedasUseCase;
    }

    @Override
    public Moneda crear(Moneda moneda) {
        return crearMonedaUseCase.crear(moneda);
    }

    @Override
    public Moneda actualizar(Integer id, Moneda moneda) {
        return actualizarMonedaUseCase.actualizar(id, moneda);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarMonedaUseCase.eliminar(id);
    }

    @Override
    public Optional<Moneda> obtenerPorId(Integer id) {
        return obtenerMonedaUseCase.obtenerPorId(id);
    }

    @Override
    public List<Moneda> listar() {
        return listarMonedasUseCase.listar();
    }
}

