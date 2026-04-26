package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;
    private String descripcion;
    private String razonSocial;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento_identidad")
    private TipoDocumentoIdentidadEntity tipoDocumentoIdentidad;
    private String numeroDocumento;
    private String direccion;
    private String celular;
    private String correo;
    @OneToMany
    private List<ComprobantePagoEntity> comprobantes;

    public ClienteEntity(String descripcion, String razonSocial, String nombres, String apellidoPaterno, String apellidoMaterno, TipoDocumentoIdentidadEntity tipoDocumentoIdentidad, String numeroDocumento, String direccion, String celular, String correo, List<ComprobantePagoEntity> comprobantes) {
        this.descripcion = descripcion;
        this.razonSocial = razonSocial;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.comprobantes = comprobantes;
    }

    public ClienteEntity() {

    }

    public ClienteEntity(Integer id, String descripcion, String razonSocial, String nombres, String apellidoPaterno, String apellidoMaterno, TipoDocumentoIdentidadEntity tipoDocumentoIdentidad, String numeroDocumento, String direccion, String celular, String correo, List<ComprobantePagoEntity> comprobantes) {
        this.id = id;
        this.descripcion = descripcion;
        this.razonSocial = razonSocial;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.comprobantes = comprobantes;
    }
}
