package org.luis.proyecto.application.usecase.producto.impl;
import org.luis.proyecto.application.usecase.producto.ListarProductosUseCase;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ListarProductosUseCaseImpl implements ListarProductosUseCase {
    private final ProductoRepository productoRepository;
    public ListarProductosUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public List<Producto> listar() {
        return productoRepository.findAll().stream()
                .filter(p -> p.getIteAlmEstado() == null || p.getIteAlmEstado())
                .toList();
    }
}
