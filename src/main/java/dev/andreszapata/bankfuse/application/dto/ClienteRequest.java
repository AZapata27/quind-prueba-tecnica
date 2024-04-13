package dev.andreszapata.bankfuse.application.dto;

import lombok.Data;

@Data
public class ClienteRequest {
    private String nombre;
    private String apellidos;
    private String tipoIdentificacion;
    private int numeroIdentificacion;
    private String correoElectronico;
    private String fechaNacimiento;
}
