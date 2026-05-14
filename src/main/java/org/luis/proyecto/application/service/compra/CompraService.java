package org.luis.proyecto.application.service.compra;

import org.luis.proyecto.domain.model.Compra;

import java.util.List;

public interface CompraService {
    Compra crear(Compra compra);

    Compra actualizar(Integer id, Compra compra);

    void eliminar(Integer id);

    Compra obtenerCompra(Integer id);

    List<Compra> obtenerTodas();
}

