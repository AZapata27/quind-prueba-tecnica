package dev.andreszapata.bankfuse.domain.model;

import dev.andreszapata.bankfuse.domain.enums.TipoIdentificacion;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    static final String REGEX_CORREO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    private Long idClient;
    private TipoIdentificacion tipoIdentificacion;
    private Integer numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String correoElectronico;

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
        return nombres !=null && nombres.length() >= 2 && apellidos !=null && apellidos.length() >= 2;
    }

    public boolean esIdentificacionValida() {
        return numeroIdentificacion !=null && numeroIdentificacion > 0;
    }
}
