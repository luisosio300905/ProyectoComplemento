package org.luis.proyecto.application.usecase.moneda;

import org.luis.proyecto.domain.model.Moneda;
import java.util.Optional;

public interface ObtenerMonedaUseCase {
    Optional<Moneda> obtenerPorId(Integer id);
}
