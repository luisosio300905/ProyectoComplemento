package org.luis.proyecto.infrastructure.mapper;

import org.luis.proyecto.domain.model.Cliente;
import org.luis.proyecto.infrastructure.persistence.entity.ClienteEntity;
import org.luis.proyecto.infrastructure.rest.request.ClienteRequest;
import org.luis.proyecto.infrastructure.rest.response.ClienteResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {
    private final TipoDocumentoIdentidadMapper tipoDocumentoIdentidadMapper;

    public ClienteMapper(TipoDocumentoIdentidadMapper tipoDocumentoIdentidadMapper) {
        this.tipoDocumentoIdentidadMapper = tipoDocumentoIdentidadMapper;
    }

    public Cliente toCliente(ClienteEntity clienteEntity) {
        return new Cliente(
                clienteEntity.getId(),
                clienteEntity.getDescripcion(),
                clienteEntity.getRazonSocial(),
                clienteEntity.getNombres(),
                clienteEntity.getApellidoPaterno(),
                clienteEntity.getApellidoMaterno(),
                tipoDocumentoIdentidadMapper
                        .toTipoDocumentoIdentidad(clienteEntity.getTipoDocumentoIdentidad()),
                clienteEntity.getNumeroDocumento(),
                clienteEntity.getDireccion(),
                clienteEntity.getCelular(),
                clienteEntity.getCorreo(),
                null
        );
    }

    public ClienteEntity toClienteEntity(Cliente cliente) {
        return new ClienteEntity(
                cliente.getId(),
                cliente.getDescripcion(),
                cliente.getRazonSocial(),
                cliente.getNombres(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(),
                tipoDocumentoIdentidadMapper
                        .toTipoDocumentoIdentidadEntity(cliente.getTipoDocumentoIdentidad()),
                cliente.getNumeroDocumento(),
                cliente.getDireccion(),
                cliente.getCelular(),
                cliente.getCorreo(),
                null
        );
    }

    public Cliente toCliente(ClienteRequest clienteRequest) {
        return new Cliente(
                clienteRequest.descripcion(),
                clienteRequest.razonSocial(),
                clienteRequest.nombres(),
                clienteRequest.apellidoPaterno(),
                clienteRequest.apellidoMaterno(),
                clienteRequest.tipoDocumentoIdentidad(),
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
