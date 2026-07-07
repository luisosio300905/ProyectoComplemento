package org.luis.proyecto.application.usecase.producto;
import org.luis.proyecto.domain.model.Producto;
import java.util.Optional;
public interface ObtenerProductoUseCase {
    Optional<Producto> obtenerPorId(Integer id);
}
