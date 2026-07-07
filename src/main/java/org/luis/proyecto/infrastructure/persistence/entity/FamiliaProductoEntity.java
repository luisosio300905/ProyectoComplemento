package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "FamiliaProducto")
public class FamiliaProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FamId")
    private Integer id;
    @Column(name = "FamDescripcion")
    private String famDescripcion;
    @Column(name = "FamEstado")
    private Boolean famEstado;
    @Column(name = "codfam")
    private String codfam;
    @Column(name = "UsrSistema")
    private String usrSistema;
    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;
    @Column(name = "HrsSistema")
    private String hrsSistema;

    public FamiliaProductoEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFamDescripcion() { return famDescripcion; }
    public void setFamDescripcion(String famDescripcion) { this.famDescripcion = famDescripcion; }
    public Boolean getFamEstado() { return famEstado; }
    public void setFamEstado(Boolean famEstado) { this.famEstado = famEstado; }
    public String getCodfam() { return codfam; }
    public void setCodfam(String codfam) { this.codfam = codfam; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
