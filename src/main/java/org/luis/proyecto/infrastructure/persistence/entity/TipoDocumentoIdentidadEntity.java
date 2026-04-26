package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos_documento_identidad")
public class TipoDocumentoIdentidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento_identidad")
    private Integer id;
}
