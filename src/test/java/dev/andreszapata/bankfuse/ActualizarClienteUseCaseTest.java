package dev.andreszapata.bankfuse;

import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;
import dev.andreszapata.bankfuse.domain.usecases.ActualizarClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ActualizarClienteUseCaseTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ActualizarClienteUseCase actualizarClienteUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutar_ClienteExistente_ActualizaCliente() {

        Client clienteExistente = new Client();
        clienteExistente.setIdClient(1L);

        when(clientRepository.existeCliente(1L)).thenReturn(true);

        actualizarClienteUseCase.ejecutar(clienteExistente);

        verify(clientRepository, times(1)).actualizarCliente(clienteExistente);
    }

    @Test
    public void ejecutar_ClienteNoExistente_LanzaExcepcion() {

        Client clienteNoExistente = new Client();
        clienteNoExistente.setIdClient(2L);

        when(clientRepository.existeCliente(2L)).thenReturn(false);

        assertThrows(CustomException.class, () -> actualizarClienteUseCase.ejecutar(clienteNoExistente));
    }
}
