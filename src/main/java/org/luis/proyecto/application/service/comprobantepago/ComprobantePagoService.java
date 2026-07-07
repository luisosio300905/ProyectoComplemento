package org.luis.proyecto.application.service.comprobantepago;

import org.luis.proyecto.domain.model.ComprobantePago;

import java.util.List;

public interface ComprobantePagoService {
    ComprobantePago crear(ComprobantePago comprobantePago);
    ComprobantePago actualizar(String id, ComprobantePago comprobantePago);
    void eliminar(String id);
    ComprobantePago obtenerComprobantePago(String id);
    List<ComprobantePago> obtenerTodos();
}
