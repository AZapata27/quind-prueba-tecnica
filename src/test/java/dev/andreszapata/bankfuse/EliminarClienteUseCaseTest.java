package dev.andreszapata.bankfuse;

import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;
import dev.andreszapata.bankfuse.domain.usecases.EliminarClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EliminarClienteUseCaseTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private EliminarClienteUseCase eliminarClienteUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutar_ClienteSinProductosVinculados_EliminaCliente() {

        Long idCliente = 1L;

        when(clientRepository.tieneProductosVinculadosActivos(idCliente)).thenReturn(false);

        eliminarClienteUseCase.ejecutar(idCliente);

        verify(clientRepository, times(1)).eliminarCliente(idCliente);
    }

    @Test
    public void ejecutar_ClienteConProductosVinculados_LanzaExcepcion() {

        Long idCliente = 2L;

        when(clientRepository.tieneProductosVinculadosActivos(idCliente)).thenReturn(true);

        assertThrows(CustomException.class, () -> eliminarClienteUseCase.ejecutar(idCliente));
    }
}
