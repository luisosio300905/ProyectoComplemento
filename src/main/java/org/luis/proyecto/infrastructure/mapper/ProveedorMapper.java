package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Proveedor;
import org.luis.proyecto.infrastructure.persistence.entity.ProveedorEntity;
import org.luis.proyecto.infrastructure.persistence.entity.TipoDocumentoIdentidadEntity;
import org.luis.proyecto.infrastructure.persistence.repository.JpaTipoDocumentoIdentidadRepository;
import org.luis.proyecto.infrastructure.rest.request.ProveedorRequest;
import org.luis.proyecto.infrastructure.rest.response.ProveedorResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ProveedorMapper {
    private final TipoDocumentoIdentidadMapper tipoDocumentoIdentidadMapper;
    private final JpaTipoDocumentoIdentidadRepository jpaTipoDocumentoIdentidadRepository;

    public ProveedorMapper(TipoDocumentoIdentidadMapper tipoDocumentoIdentidadMapper,
                          JpaTipoDocumentoIdentidadRepository jpaTipoDocumentoIdentidadRepository) {
        this.tipoDocumentoIdentidadMapper = tipoDocumentoIdentidadMapper;
        this.jpaTipoDocumentoIdentidadRepository = jpaTipoDocumentoIdentidadRepository;
    }

    public Proveedor toProveedor(ProveedorEntity proveedorEntity) {
        if (proveedorEntity == null) {
            return null;
        }
        
        Proveedor proveedor = new Proveedor(
                proveedorEntity.getId(),
                proveedorEntity.getNombre(),
                proveedorEntity.getDescripcion(),
                proveedorEntity.getRazonSocial(),
                tipoDocumentoIdentidadMapper.toTipoDocumentoIdentidad(
                        proveedorEntity.getTipoDocumentoIdentidad()
                ),
                proveedorEntity.getNumeroDocumento(),
                proveedorEntity.getDireccion(),
                proveedorEntity.getCelular(),
                proveedorEntity.getCorreo(),
                proveedorEntity.getFechaIngreso(),
                proveedorEntity.getEstado(),
                proveedorEntity.getUltimoComprobante()
        );
        return proveedor;
    }

    public ProveedorEntity toProveedorEntity(Proveedor proveedor) {
        if (proveedor == null) {
            return null;
        }

        TipoDocumentoIdentidadEntity tipoDocEntity = proveedor.getTipoDocumentoIdentidad() != null
                ? tipoDocumentoIdentidadMapper.toTipoDocumentoIdentidadEntity(
                        proveedor.getTipoDocumentoIdentidad()
                )
                : null;

        return new ProveedorEntity(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getDescripcion(),
                proveedor.getRazonSocial(),
                tipoDocEntity,
                proveedor.getNumeroDocumento(),
                proveedor.getDireccion(),
                proveedor.getCelular(),
                proveedor.getCorreo(),
                proveedor.getFechaIngreso(),
                proveedor.getEstado(),
                proveedor.getUltimoComprobante()
        );
    }

    public Proveedor toProveedor(ProveedorRequest proveedorRequest) {
        if (proveedorRequest == null) {
            return null;
        }

        // Buscar tipo documento por ID
        TipoDocumentoIdentidadEntity tipoDocEntity = jpaTipoDocumentoIdentidadRepository
                .findById(proveedorRequest.idTipoDocumento())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de documento no encontrado"));

        return new Proveedor(
                proveedorRequest.nombre(),
                proveedorRequest.descripcion(),
                proveedorRequest.razonSocial(),
                tipoDocumentoIdentidadMapper.toTipoDocumentoIdentidad(tipoDocEntity),
                proveedorRequest.numeroDocumento(),
                proveedorRequest.direccion(),
                proveedorRequest.celular(),
                proveedorRequest.correo(),
                LocalDateTime.now(),
                "activo",
                null
        );
    }

    public List<Proveedor> toProveedorList(List<ProveedorEntity> proveedoresEntities) {
        return proveedoresEntities
                .stream()
                .map(this::toProveedor)
                .toList();
    }

    public ProveedorResponse toProveedorResponse(Proveedor proveedor) {
        if (proveedor == null) {
            return null;
        }

        return new ProveedorResponse(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getDescripcion(),
                proveedor.getRazonSocial(),
                proveedor.getTipoDocumentoIdentidad(),
                proveedor.getNumeroDocumento(),
                proveedor.getDireccion(),
                proveedor.getCelular(),
                proveedor.getCorreo(),
                proveedor.getFechaIngreso(),
                proveedor.getEstado()
        );
    }

    public List<ProveedorResponse> toProveedorResponseList(List<Proveedor> proveedores) {
        return proveedores
                .stream()
                .map(this::toProveedorResponse)
                .toList();
    }
}

