package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class VentaEntity {
    @Id
    @GeneratedValue
    private Integer id;
}
