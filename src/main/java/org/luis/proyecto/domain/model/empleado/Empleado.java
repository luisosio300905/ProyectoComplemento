package org.luis.proyecto.domain.model.empleado;
import org.luis.proyecto.domain.model.tipodocumentoidentidad.TipoDocumentoIdentidad;

import java.time.LocalDate;

public class Empleado {
    private Integer id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private LocalDate fechaNacimiento;
    private TipoDocumentoIdentidad tipoDocumento;
    private String numeroDocumento;
    private String sexo;
    private String telefono;
    private String correo;
    private String estadoCivil;

}


