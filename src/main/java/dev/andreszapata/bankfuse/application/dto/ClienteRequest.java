package dev.andreszapata.bankfuse.application.dto;

import dev.andreszapata.bankfuse.domain.enums.TipoIdentificacion;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteRequest {
    private String nombres;
    private String apellidos;
    private TipoIdentificacion tipoIdentificacion;
    private Integer numeroIdentificacion;
    private String correoElectronico;
    private LocalDate fechaNacimiento;
}

