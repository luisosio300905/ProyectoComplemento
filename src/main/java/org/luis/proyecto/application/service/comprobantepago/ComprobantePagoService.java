package org.luis.proyecto.application.service.comprobantepago;

import org.luis.proyecto.domain.model.ComprobantePago;

import java.util.List;

public interface ComprobantePagoService {
    ComprobantePago crear(ComprobantePago comprobantePago);
    ComprobantePago actualizar(Integer id, ComprobantePago comprobantePago);
    void eliminar(Integer id);
    ComprobantePago obtenerComprobantePago(Integer id);
    List<ComprobantePago> obtenerTodos();
}
