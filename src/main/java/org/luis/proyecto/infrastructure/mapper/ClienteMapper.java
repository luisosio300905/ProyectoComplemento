package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.infrastructure.persistence.entity.ClienteEntity;
import org.luis.proyecto.infrastructure.persistence.entity.TipoDocumentoIdentidadEntity;
import org.luis.proyecto.infrastructure.persistence.repository.JpaTipoDocumentoIdentidadRepository;
import org.luis.proyecto.infrastructure.rest.request.ClienteRequest;
import org.luis.proyecto.infrastructure.rest.response.ClienteResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {
    private final TipoDocumentoIdentidadMapper tipoDocumentoIdentidadMapper;
    private final JpaTipoDocumentoIdentidadRepository jpaTipoDocumentoIdentidadRepository;

    public ClienteMapper(TipoDocumentoIdentidadMapper tipoDocumentoIdentidadMapper,
                        JpaTipoDocumentoIdentidadRepository jpaTipoDocumentoIdentidadRepository) {
        this.tipoDocumentoIdentidadMapper = tipoDocumentoIdentidadMapper;
        this.jpaTipoDocumentoIdentidadRepository = jpaTipoDocumentoIdentidadRepository;
    }

    public Cliente toCliente(ClienteEntity clienteEntity) {
        if (clienteEntity == null) {
            return null;
        }
        return new Cliente(
                clienteEntity.getId(),
                clienteEntity.getDescripcion(),
                clienteEntity.getRazonSocial(),
                clienteEntity.getNombres(),
                clienteEntity.getApellidoPaterno(),
                clienteEntity.getApellidoMaterno(),
                tipoDocumentoIdentidadMapper.toTipoDocumentoIdentidad(clienteEntity.getTipoDocumentoIdentidad()),
                clienteEntity.getNumeroDocumento(),
                clienteEntity.getDireccion(),
                clienteEntity.getCelular(),
                clienteEntity.getCorreo(),
                null
        );
    }

    public ClienteEntity toClienteEntity(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return new ClienteEntity(
                cliente.getId(),
                cliente.getDescripcion(),
                cliente.getRazonSocial(),
                cliente.getNombres(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(),
                tipoDocumentoIdentidadMapper.toTipoDocumentoIdentidadEntity(cliente.getTipoDocumentoIdentidad()),
                cliente.getNumeroDocumento(),
                cliente.getDireccion(),
                cliente.getCelular(),
                cliente.getCorreo(),
                null
        );
    }

    public Cliente toCliente(ClienteRequest clienteRequest) {
        if (clienteRequest == null) {
            return null;
        }
        TipoDocumentoIdentidadEntity tipoDocEntity = jpaTipoDocumentoIdentidadRepository
                .findById(clienteRequest.idTipoDocumento())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de documento no encontrado"));

        return new Cliente(
                clienteRequest.descripcion(),
                clienteRequest.razonSocial(),
                clienteRequest.nombres(),
                clienteRequest.apellidoPaterno(),
                clienteRequest.apellidoMaterno(),
                tipoDocumentoIdentidadMapper.toTipoDocumentoIdentidad(tipoDocEntity),
                clienteRequest.numeroDocumento(),
                clienteRequest.direccion(),
                clienteRequest.celular(),
                clienteRequest.correo(),
                null
        );
    }

    public List<Cliente> toClienteList(List<ClienteEntity> clientesEntities) {
        return clientesEntities
                .stream()
                .map(this::toCliente)
                .toList();
    }

    public ClienteResponse toClienteResponse(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return new ClienteResponse(
                cliente.getId(),
                cliente.getDescripcion(),
                cliente.getRazonSocial(),
                cliente.getNombres(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(),
                cliente.getTipoDocumentoIdentidad(),
                cliente.getNumeroDocumento(),
                cliente.getDireccion(),
                cliente.getCelular(),
                cliente.getCorreo()
        );
    }

    public List<ClienteResponse> toClienteResponseList(List<Cliente> clientes) {
        return clientes
                .stream()
                .map(this::toClienteResponse)
                .toList();
    }
}
