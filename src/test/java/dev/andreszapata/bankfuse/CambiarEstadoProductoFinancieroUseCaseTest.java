package dev.andreszapata.bankfuse;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;
import dev.andreszapata.bankfuse.domain.usecases.CambiarEstadoProductoFinancieroUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CambiarEstadoProductoFinancieroUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CambiarEstadoProductoFinancieroUseCase cambiarEstadoProductoFinancieroUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutar_CambioDeEstadoExitoso() {

        Long idProducto = 1L;
        EstadoCuenta nuevoEstado = EstadoCuenta.ACTIVA;
        Product producto = new Product(idProducto, null, null, EstadoCuenta.CANCELADA, 0.0, null, null);

        when(productRepository.obtenerProductoPorId(idProducto)).thenReturn(producto);

        cambiarEstadoProductoFinancieroUseCase.ejecutar(idProducto, nuevoEstado);

        assertEquals(nuevoEstado, producto.getEstadoCuenta());
        verify(productRepository, times(1)).actualizarProducto(producto);
    }
}
