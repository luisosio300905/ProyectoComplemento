package org.luis.proyecto.application.usecase.producto;
import org.luis.proyecto.domain.model.Producto;
import java.util.List;
public interface ListarProductosUseCase {
    List<Producto> listar();
}
