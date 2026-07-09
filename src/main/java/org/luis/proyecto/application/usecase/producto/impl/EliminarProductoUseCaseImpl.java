package org.luis.proyecto.application.usecase.producto.impl;
import org.luis.proyecto.application.usecase.producto.EliminarProductoUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.luis.proyecto.domain.repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class EliminarProductoUseCaseImpl implements EliminarProductoUseCase {
    private final ProductoRepository productoRepository;
    private final DetalleVentaRepository detalleVentaRepository;

    public EliminarProductoUseCaseImpl(ProductoRepository productoRepository, DetalleVentaRepository detalleVentaRepository) {
        this.productoRepository = productoRepository;
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public void eliminar(Integer id) {
        var productoOpt = productoRepository.findById(id);
        if (productoOpt.isEmpty()) {
            throw new ResourceNotFoundException("Producto no encontrado con id " + id);
        }
        
        if (detalleVentaRepository.existsByProductoId(id)) {
            var producto = productoOpt.get();
            producto.setIteAlmEstado(false);
            producto.setIteAlmFecBaja(LocalDateTime.now());
            productoRepository.save(producto);
        } else {
            productoRepository.deleteById(id);
        }
    }
}
