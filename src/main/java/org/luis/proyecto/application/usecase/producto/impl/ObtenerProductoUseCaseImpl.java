package org.luis.proyecto.application.usecase.producto.impl;
import org.luis.proyecto.application.usecase.producto.ObtenerProductoUseCase;
import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ObtenerProductoUseCaseImpl implements ObtenerProductoUseCase {
    private final ProductoRepository productoRepository;
    public ObtenerProductoUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }
}
