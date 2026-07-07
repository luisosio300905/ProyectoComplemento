package org.luis.proyecto.application.usecase.moneda;

import org.luis.proyecto.domain.model.Moneda;
import java.util.List;

public interface ListarMonedasUseCase {
    List<Moneda> listar();
}
