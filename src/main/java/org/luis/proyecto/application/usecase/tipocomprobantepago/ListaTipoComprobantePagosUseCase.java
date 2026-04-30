package org.luis.proyecto.application.usecase.tipocomprobantepago;

import org.luis.proyecto.domain.model.TipoComprobantePago;
import java.util.List;

public interface ListaTipoComprobantePagosUseCase {
    List<TipoComprobantePago> listar();
}