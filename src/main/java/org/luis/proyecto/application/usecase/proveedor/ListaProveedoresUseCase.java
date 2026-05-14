package org.luis.proyecto.application.usecase.proveedor;

import org.luis.proyecto.domain.model.Proveedor;

import java.util.List;

public interface ListaProveedoresUseCase {
    List<Proveedor> obtenerTodos();
}

