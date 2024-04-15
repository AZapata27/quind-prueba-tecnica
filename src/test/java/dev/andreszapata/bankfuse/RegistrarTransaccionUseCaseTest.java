package dev.andreszapata.bankfuse;

import dev.andreszapata.bankfuse.domain.enums.TipoTransaction;
import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Transaction;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;
import dev.andreszapata.bankfuse.domain.repository.TransaccionRepository;
import dev.andreszapata.bankfuse.domain.usecases.RegistrarTransaccionUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RegistrarTransaccionUseCaseTest {

    @Mock
    private TransaccionRepository transaccionRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private RegistrarTransaccionUseCase registrarTransaccionUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void ejecutar_ValidTransaction_CallsRepositoriesAndRegistersTransaction() {

        Transaction transaction = new Transaction(1L, 1L, 1L, TipoTransaction.CONSIGNACION,
                LocalDateTime.now(), 100.0, 0);

        when(productRepository.obtenerSaldoProducto(anyLong())).thenReturn(500.0);

        registrarTransaccionUseCase.ejecutar(transaction);

        // Assert
        verify(productRepository, times(1)).obtenerSaldoProducto(anyLong());
        verify(productRepository, times(1)).actualizarSaldoProducto(anyLong(), anyDouble());
        verify(transaccionRepository, times(1)).registrarTransaccion(transaction);
    }

    @Test
    void ejecutar_InvalidAmount_ThrowsCustomException() {

        Transaction transaction = new Transaction(1L, 1L, 1L, TipoTransaction.CONSIGNACION,
                LocalDateTime.now(), -50.0, 0);

        assertThrows(CustomException.class, () -> registrarTransaccionUseCase.ejecutar(transaction));
    }

    @Test
    void ejecutar_TransferTransaction_CallsRepositoriesAndRegistersTransaction() {

        Transaction transaction = new Transaction(1L, 1L, 1L, TipoTransaction.TRANSFERENCIA,
                LocalDateTime.now(), 200.0, 123456);

        when(productRepository.obtenerSaldoProducto(anyLong())).thenReturn(500.0);

        registrarTransaccionUseCase.ejecutar(transaction);

        verify(productRepository, times(1)).obtenerSaldoProducto(anyLong());
        verify(productRepository, times(1)).actualizarSaldoProducto(anyLong(), anyDouble());
        verify(transaccionRepository, times(1)).registrarTransaccion(transaction);
    }


}
