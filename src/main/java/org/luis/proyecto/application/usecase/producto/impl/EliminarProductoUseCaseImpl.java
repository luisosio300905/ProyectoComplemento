package org.luis.proyecto.application.usecase.producto.impl;
import org.luis.proyecto.application.usecase.producto.EliminarProductoUseCase;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;
@Service
public class EliminarProductoUseCaseImpl implements EliminarProductoUseCase {
    private final ProductoRepository productoRepository;
    public EliminarProductoUseCaseImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public void eliminar(Integer id) {
        if (productoRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Producto no encontrado con id " + id);
        }
        productoRepository.deleteById(id);
    }
}
