package dev.andreszapata.bankfuse;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;
import dev.andreszapata.bankfuse.domain.usecases.CancelarProductoFinancieroUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CancelarProductoFinancieroUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CancelarProductoFinancieroUseCase cancelarProductoFinancieroUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutar_ProductoConSaldoDistintoDeCero_LanzaExcepcion() {

        Long idProducto = 1L;
        Product productoConSaldo = new Product(idProducto, null, null, null, 100.0, null, null);

        when(productRepository.obtenerProductoPorId(idProducto)).thenReturn(productoConSaldo);

        assertThrows(CustomException.class, () -> cancelarProductoFinancieroUseCase.ejecutar(idProducto));
    }

    @Test
    public void ejecutar_CancelacionExitosa() {

        Long idProducto = 1L;
        Product productoSinSaldo = new Product(idProducto, null, null, null, 0.0, null, null);

        when(productRepository.obtenerProductoPorId(idProducto)).thenReturn(productoSinSaldo);

        cancelarProductoFinancieroUseCase.ejecutar(idProducto);

        verify(productRepository, times(1)).actualizarProducto(productoSinSaldo);
        assertEquals(EstadoCuenta.CANCELADA, productoSinSaldo.getEstadoCuenta());
    }
}
