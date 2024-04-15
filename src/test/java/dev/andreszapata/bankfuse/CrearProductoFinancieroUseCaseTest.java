package dev.andreszapata.bankfuse;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.enums.TipoCuenta;
import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;
import dev.andreszapata.bankfuse.domain.usecases.CrearProductoFinancieroUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CrearProductoFinancieroUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private CrearProductoFinancieroUseCase crearProductoFinancieroUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejecutar_ClienteNoExiste_LanzaExcepcion() {

        TipoCuenta tipoCuenta = TipoCuenta.CUENTA_CORRIENTE;
        Long idCliente = 1L;

        when(clientRepository.existeCliente(idCliente)).thenReturn(false);

        assertThrows(CustomException.class, () -> crearProductoFinancieroUseCase.ejecutar(tipoCuenta, idCliente));
    }

    @Test
    public void ejecutar_TipoCuentaInvalido_LanzaExcepcion() {

        TipoCuenta tipoCuentaInvalido = null;
        Long idCliente = 1L;

        when(clientRepository.existeCliente(idCliente)).thenReturn(true);

        assertThrows(CustomException.class, () -> crearProductoFinancieroUseCase.ejecutar(tipoCuentaInvalido, idCliente));
    }

    @Test
    public void ejecutar_ClienteYaTieneProductoActivo_LanzaExcepcion() {

        TipoCuenta tipoCuenta = TipoCuenta.CUENTA_CORRIENTE;
        Long idCliente = 1L;

        when(clientRepository.existeCliente(idCliente)).thenReturn(true);
        when(productRepository.existeProductoActivoByClientId(idCliente)).thenReturn(true);

        assertThrows(CustomException.class, () -> crearProductoFinancieroUseCase.ejecutar(tipoCuenta, idCliente));
    }

    @Test
    public void ejecutar_CrearProductoFinancieroExitoso() {

        TipoCuenta tipoCuenta = TipoCuenta.CUENTA_CORRIENTE;
        Long idCliente = 1L;
        Product productoMock = new Product(null, tipoCuenta, 3300000001L, EstadoCuenta.ACTIVA, 0.0, false, idCliente);
        when(clientRepository.existeCliente(idCliente)).thenReturn(true);
        when(productRepository.existeProductoActivoByClientId(idCliente)).thenReturn(false);
        when(productRepository.registrarProducto(any(Product.class))).thenReturn(1L);

        Long idProducto = crearProductoFinancieroUseCase.ejecutar(tipoCuenta, idCliente);

        assertNotNull(idProducto);
        assertEquals(1L, idProducto);
    }
}
