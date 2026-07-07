package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Laboratorio")
public class LaboratorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LabId")
    private Integer id;
    @Column(name = "LabDescripcion")
    private String labDescripcion;
    @Column(name = "LabEstado")
    private Boolean labEstado;
    @Column(name = "codlab")
    private String codlab;
    @Column(name = "UsrSistema")
    private String usrSistema;
    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;
    @Column(name = "HrsSistema")
    private String hrsSistema;

    public LaboratorioEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getLabDescripcion() { return labDescripcion; }
    public void setLabDescripcion(String labDescripcion) { this.labDescripcion = labDescripcion; }
    public Boolean getLabEstado() { return labEstado; }
    public void setLabEstado(Boolean labEstado) { this.labEstado = labEstado; }
    public String getCodlab() { return codlab; }
    public void setCodlab(String codlab) { this.codlab = codlab; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
