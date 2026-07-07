package org.luis.proyecto.domain.model;

import java.time.LocalDateTime;

public class ComprobantePago {
    private String id;
    private String comPagDescripcion;
    private String usrSistema;
    private LocalDateTime fecSistema;
    private String hrsSistema;

    public ComprobantePago() {}

    public ComprobantePago(String id) {
        this.id = id;
    }

    public ComprobantePago(String id, String comPagDescripcion, String usrSistema, LocalDateTime fecSistema, String hrsSistema) {
        this.id = id;
        this.comPagDescripcion = comPagDescripcion;
        this.usrSistema = usrSistema;
        this.fecSistema = fecSistema;
        this.hrsSistema = hrsSistema;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getComPagDescripcion() { return comPagDescripcion; }
    public void setComPagDescripcion(String comPagDescripcion) { this.comPagDescripcion = comPagDescripcion; }
    public String getUsrSistema() { return usrSistema; }
    public void setUsrSistema(String usrSistema) { this.usrSistema = usrSistema; }
    public LocalDateTime getFecSistema() { return fecSistema; }
    public void setFecSistema(LocalDateTime fecSistema) { this.fecSistema = fecSistema; }
    public String getHrsSistema() { return hrsSistema; }
    public void setHrsSistema(String hrsSistema) { this.hrsSistema = hrsSistema; }
}


