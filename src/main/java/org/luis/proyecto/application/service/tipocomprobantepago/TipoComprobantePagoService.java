package org.luis.proyecto.application.service.tipocomprobantepago;

import org.luis.proyecto.domain.model.TipoComprobantePago;
import java.util.List;

public interface TipoComprobantePagoService {
    TipoComprobantePago crear(TipoComprobantePago tipoComprobantePago);
    TipoComprobantePago actualizar(Integer id, TipoComprobantePago tipoComprobantePago);
    void eliminar(Integer id);
    TipoComprobantePago obtenerTipoComprobantePago(Integer id);
    List<TipoComprobantePago> obtenerTodos();
}