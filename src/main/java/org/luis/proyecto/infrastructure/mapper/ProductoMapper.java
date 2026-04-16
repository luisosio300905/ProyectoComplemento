package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Producto;
import org.luis.proyecto.infrastructure.persistence.entity.ProductoEntity;
import org.luis.proyecto.infrastructure.rest.request.ProductoRequest;
import org.luis.proyecto.infrastructure.rest.response.ProductoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductoMapper {

    public Producto toProducto(ProductoEntity productoEntity) {
        return new Producto(
                productoEntity.getId(),
                productoEntity.getNombre(),
                productoEntity.getCodigo(),
                productoEntity.getDescripcion(),
                productoEntity.getCategoria(),
                productoEntity.getPrecio(),
                productoEntity.getStock()
        );
    }

    public ProductoEntity toProductoEntity(Producto producto) {
        return new ProductoEntity(
                producto.getId(),
                producto.getNombre(),
                producto.getCodigo(),
                producto.getDescripcion(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    public Producto toProducto(ProductoRequest productoRequest) {
        return new Producto(
                productoRequest.nombre(),
                productoRequest.codigo(),
                productoRequest.descripcion(),
                productoRequest.categoria(),
                productoRequest.precio(),
                productoRequest.stock());
    }

    public List<Producto> toProductoList(List<ProductoEntity> productosEntities) {
        return productosEntities
                .stream()
                .map(p -> toProducto(p))
                .toList();
    }

    public ProductoResponse toProductoResponse(Producto producto) {
        return new ProductoResponse(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCategoria(),
                producto.getPrecio()
        );
    }

    public List<ProductoResponse> toProductoResponseList(List<Producto> productos) {
        return productos
                .stream()
                .map(p -> toProductoResponse(p))
                .toList();
    }
}
