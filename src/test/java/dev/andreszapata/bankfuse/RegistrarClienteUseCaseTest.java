package dev.andreszapata.bankfuse;

import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;
import dev.andreszapata.bankfuse.domain.usecases.RegistrarClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RegistrarClienteUseCaseTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private RegistrarClienteUseCase registrarClienteUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutar_ClienteValido_RegistraCliente() {

        Client clienteValido = new Client();
        clienteValido.setNombres("Andres");
        clienteValido.setApellidos("Zapata");
        clienteValido.setCorreoElectronico("Andres@gmail.com");
        clienteValido.setFechaNacimiento(LocalDate.of(1990, 1, 1));
        clienteValido.setNumeroIdentificacion(123456789);

        when(clientRepository.registrarCliente(clienteValido)).thenReturn(1L);

        Long idClienteRegistrado = registrarClienteUseCase.ejecutar(clienteValido);

        assertNotNull(idClienteRegistrado);
        assertEquals(1L, idClienteRegistrado);
    }

    @Test
    public void ejecutar_ClienteMenorDeEdad_LanzaExcepcion() {
        Client clienteMenorEdad = new Client();
        clienteMenorEdad.setNombres("Andres");
        clienteMenorEdad.setApellidos("Zapata");
        clienteMenorEdad.setFechaNacimiento(LocalDate.of(2010, 1, 1)); // Menor de edad

        assertThrows(CustomException.class, () -> registrarClienteUseCase.ejecutar(clienteMenorEdad));
    }

    @Test
    public void ejecutar_NombreApellidoInvalido_LanzaExcepcion() {

        Client clienteNombreInvalido = new Client();
        clienteNombreInvalido.setNombres("J");

        clienteNombreInvalido.setCorreoElectronico("Andres@gmail.com");
        clienteNombreInvalido.setFechaNacimiento(LocalDate.of(1990, 1, 1));// Nombre corto

        assertThrows(CustomException.class, () -> registrarClienteUseCase.ejecutar(clienteNombreInvalido));
    }

    @Test
    public void ejecutar_IdentificacionInvalida_LanzaExcepcion() {

        Client clienteIdentificacionInvalida = new Client();
        clienteIdentificacionInvalida.setNombres("andres");
        clienteIdentificacionInvalida.setApellidos("zaata");
        clienteIdentificacionInvalida.setCorreoElectronico("Andres@gmail.com");
        clienteIdentificacionInvalida.setFechaNacimiento(LocalDate.of(1990, 1, 1));
        clienteIdentificacionInvalida.setNumeroIdentificacion(0); // Identificación inválida

        assertThrows(CustomException.class, () -> registrarClienteUseCase.ejecutar(clienteIdentificacionInvalida));
    }

    @Test
    public void ejecutar_CorreoElectronicoInvalido_LanzaExcepcion() {

        Client clienteCorreoInvalido = new Client();
        clienteCorreoInvalido.setNombres("John");
        clienteCorreoInvalido.setApellidos("Doe");
        clienteCorreoInvalido.setFechaNacimiento(LocalDate.of(1990, 1, 1));
        clienteCorreoInvalido.setCorreoElectronico("correo-invalido"); // Correo electrónico inválido

        assertThrows(CustomException.class, () -> registrarClienteUseCase.ejecutar(clienteCorreoInvalido));
    }

}
