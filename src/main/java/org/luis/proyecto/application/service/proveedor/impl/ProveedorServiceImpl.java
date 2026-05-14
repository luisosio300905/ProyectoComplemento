package org.luis.proyecto.application.service.proveedor.impl;

import org.luis.proyecto.application.service.proveedor.ProveedorService;
import org.luis.proyecto.application.usecase.proveedor.*;
import org.luis.proyecto.domain.model.Proveedor;

import java.util.List;

public class ProveedorServiceImpl implements ProveedorService {
    private final CrearProveedorUseCase crearProveedorUseCase;
    private final ActualizarProveedorUseCase actualizarProveedorUseCase;
    private final EliminarProveedorUseCase eliminarProveedorUseCase;
    private final ListaProveedoresUseCase listaProveedoresUseCase;
    private final ObtenerProveedorUseCase obtenerProveedorUseCase;

    public ProveedorServiceImpl(
            CrearProveedorUseCase crearProveedorUseCase,
            ActualizarProveedorUseCase actualizarProveedorUseCase,
            EliminarProveedorUseCase eliminarProveedorUseCase,
            ListaProveedoresUseCase listaProveedoresUseCase,
            ObtenerProveedorUseCase obtenerProveedorUseCase
    ) {
        this.crearProveedorUseCase = crearProveedorUseCase;
        this.actualizarProveedorUseCase = actualizarProveedorUseCase;
        this.eliminarProveedorUseCase = eliminarProveedorUseCase;
        this.listaProveedoresUseCase = listaProveedoresUseCase;
        this.obtenerProveedorUseCase = obtenerProveedorUseCase;
    }

    @Override
    public Proveedor crear(Proveedor proveedor) {
        return crearProveedorUseCase.crear(proveedor);
    }

    @Override
    public Proveedor actualizar(Integer id, Proveedor proveedor) {
        return actualizarProveedorUseCase.actualizar(id, proveedor);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarProveedorUseCase.eliminar(id);
    }

    @Override
    public Proveedor obtenerProveedor(Integer id) {
        return obtenerProveedorUseCase.obtenerProveedor(id);
    }

    @Override
    public List<Proveedor> obtenerTodos() {
        return listaProveedoresUseCase.obtenerTodos();
    }
}

