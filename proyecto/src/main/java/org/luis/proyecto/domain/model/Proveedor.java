package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;

public class Proveedor {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String razonSocial;
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;
    private String numeroDocumento;
    private String direccion;
    private String celular;
    private String correo;
    private LocalDateTime fechaIngreso;
    private String estado;
    private LocalDateTime ultimoComprobante;
}


