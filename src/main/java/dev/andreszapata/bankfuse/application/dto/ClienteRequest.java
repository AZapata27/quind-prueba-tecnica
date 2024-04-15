package dev.andreszapata.bankfuse.application.dto;

import dev.andreszapata.bankfuse.domain.enums.TipoIdentificacion;
import lombok.Data;

@Data
public class ClienteRequest {
    private String nombre;
    private String apellidos;
    private TipoIdentificacion tipoIdentificacion;
    private int numeroIdentificacion;
    private String correoElectronico;
    private String fechaNacimiento;
}
