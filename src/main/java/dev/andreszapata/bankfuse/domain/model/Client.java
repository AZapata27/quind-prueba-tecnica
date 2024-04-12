package dev.andreszapata.bankfuse.domain.model;

import dev.andreszapata.bankfuse.domain.enums.TipoIdentificacion;

import java.time.LocalDate;

public class Client {

    static final String REGEX_CORREO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private Long idClient;
    private TipoIdentificacion tipoIdentificacion;
    private int numeroIdentificacion;
    private String nombres;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String correoElectronico;

    public Client(Long idClient, TipoIdentificacion tipoIdentificacion,
                  int numeroIdentificacion, String nombres, String apellido,
                  LocalDate fechaNacimiento, String correoElectronico) {
        this.idClient = idClient;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }


    public boolean esMenorDeEdad() {
        LocalDate fechaActual = LocalDate.now();
        byte mayoriaEdadColombia = 18;
        return fechaNacimiento.plusYears(mayoriaEdadColombia).isAfter(fechaActual);
        //existen varias formas de validar mayoria de edad pero considero que esta es la mas simple y eficiente
        //si fecha actual es despues de fecha de nacimiento con la suma mayoria de edad colombia
    }

    public boolean esFormatoCorreoValido() {
        return correoElectronico.matches(REGEX_CORREO);
    }

    public boolean tieneLongitudNombreValida() {
        return nombres.length() >= 2 && apellido.length() >= 2;
    }
}
