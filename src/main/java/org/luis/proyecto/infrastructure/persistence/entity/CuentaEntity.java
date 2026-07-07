package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Cuenta")
public class CuentaEntity {
    @Id
    @Column(name = "CuentaId")
    private String cuentaId;

    @Column(name = "CuentaDescripcion")
    private String cuentaDescripcion;

    @Column(name = "CuentaEstado")
    private Boolean cuentaEstado;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubCuentaEntity> subCuentas;

    public CuentaEntity() {}

    // Getters y Setters
    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getCuentaDescripcion() { return cuentaDescripcion; }
    public void setCuentaDescripcion(String cuentaDescripcion) { this.cuentaDescripcion = cuentaDescripcion; }

    public Boolean getCuentaEstado() { return cuentaEstado; }
    public void setCuentaEstado(Boolean cuentaEstado) { this.cuentaEstado = cuentaEstado; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public List<SubCuentaEntity> getSubCuentas() { return subCuentas; }
    public void setSubCuentas(List<SubCuentaEntity> subCuentas) { this.subCuentas = subCuentas; }
}

