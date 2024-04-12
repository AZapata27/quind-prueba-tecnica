package dev.andreszapata.bankfuse.application.dto;

import lombok.Data;

@Data
public class ClienteRequest {
    private String nombre;
    private String apellido;
    private String tipoIdentificacion;
    private int numeroIdentificacion;
    private String correoElectronico;
    private String fechaNacimiento;
}
