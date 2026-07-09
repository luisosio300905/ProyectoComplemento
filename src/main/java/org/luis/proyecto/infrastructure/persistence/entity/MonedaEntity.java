package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Moneda")
public class MonedaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MonedaId")
    private Integer id;
    @Column(name = "MonedaDescripcion", unique = true)
    private String monedaDescripcion;
    @Column(name = "MonedaAbrev")
    private String monedaAbrev;
    @Column(name = "MonedaEst")
    private Boolean monedaEst;
    @Column(name = "MonedaAbrevSunat")
    private String monedaAbrevSunat;
    @Column(name = "UsrSistema")
    private String usrSistema;
    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;
    @Column(name = "HrsSistema")
    private String hrsSistema;

    public MonedaEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getMonedaDescripcion() { return monedaDescripcion; }
    public void setMonedaDescripcion(String monedaDescripcion) { this.monedaDescripcion = monedaDescripcion; }
    public String getMonedaAbrev() { return monedaAbrev; }
    public void setMonedaAbrev(String monedaAbrev) { this.monedaAbrev = monedaAbrev; }
    public Boolean getMonedaEst() { return monedaEst; }
    public void setMonedaEst(Boolean monedaEst) { this.monedaEst = monedaEst; }
    public String getMonedaAbrevSunat() { return monedaAbrevSunat; }
    public void setMonedaAbrevSunat(String monedaAbrevSunat) { this.monedaAbrevSunat = monedaAbrevSunat; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}
