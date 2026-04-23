package org.luis.proyecto.application.usecase.producto;

import org.luis.proyecto.domain.model.Producto;

import java.util.List;

public interface ListaProductosUseCase {
    List<Producto> obtenerTodos();
}
