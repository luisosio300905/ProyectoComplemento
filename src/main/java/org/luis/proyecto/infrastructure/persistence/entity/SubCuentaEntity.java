package org.luis.proyecto.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SubCuenta")
@IdClass(SubCuentaPK.class)
public class SubCuentaEntity {
    @Id
    @Column(name = "CuentaId")
    private String cuentaId;

    @Id
    @Column(name = "SubCtaId")
    private String subCtaId;

    @Column(name = "SubCtaDescripcion")
    private String subCtaDescripcion;

    @Column(name = "SubCtaEstado")
    private Boolean subCtaEstado;

    @Column(name = "UsrSistema")
    private String usrSistema;

    @Column(name = "FecSistema")
    private LocalDateTime fecSistema;

    @Column(name = "HrsSistema")
    private String hrsSistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CuentaId", insertable = false, updatable = false)
    private CuentaEntity cuenta;

    @OneToMany(mappedBy = "subCuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DivisionariaEntity> divisionarias;

    public SubCuentaEntity() {}

    // Getters y Setters
    public String getCuentaId() { return cuentaId; }
    public void setCuentaId(String cuentaId) { this.cuentaId = cuentaId; }

    public String getSubCtaId() { return subCtaId; }
    public void setSubCtaId(String subCtaId) { this.subCtaId = subCtaId; }

    public String getSubCtaDescripcion() { return subCtaDescripcion; }
    public void setSubCtaDescripcion(String subCtaDescripcion) { this.subCtaDescripcion = subCtaDescripcion; }

    public Boolean getSubCtaEstado() { return subCtaEstado; }
    public void setSubCtaEstado(Boolean subCtaEstado) { this.subCtaEstado = subCtaEstado; }

    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }

    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }

    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }

    public CuentaEntity getCuenta() { return cuenta; }
    public void setCuenta(CuentaEntity cuenta) { this.cuenta = cuenta; }

    public List<DivisionariaEntity> getDivisionarias() { return divisionarias; }
    public void setDivisionarias(List<DivisionariaEntity> divisionarias) { this.divisionarias = divisionarias; }
}

