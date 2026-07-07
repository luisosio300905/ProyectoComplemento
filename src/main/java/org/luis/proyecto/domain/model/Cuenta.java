package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Cuenta {
    private String cuentaId;
    private String cuentaDescripcion;
    private Boolean cuentaEstado;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;
    private List<SubCuenta> subCuentas;

    public Cuenta() {}

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

    public List<SubCuenta> getSubCuentas() { return subCuentas; }
    public void setSubCuentas(List<SubCuenta> subCuentas) { this.subCuentas = subCuentas; }
}

