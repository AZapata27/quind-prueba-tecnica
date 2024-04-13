package dev.andreszapata.bankfuse.domain.usecases;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.enums.TipoCuenta;
import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;

import java.util.Random;

public class CrearProductoFinancieroUseCase {
    private final ProductRepository productRepository;

    public CrearProductoFinancieroUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void ejecutar(TipoCuenta tipoCuenta, Long idCliente) {

        if (tipoCuenta != TipoCuenta.CUENTA_CORRIENTE && tipoCuenta != TipoCuenta.CUENTA_AHORROS) {
            throw new CustomException("Tipo de cuenta no válido");
        }

        if(productRepository.existeProductoActivoByClientId(idCliente)){
            throw new CustomException("El cliente ya tiene un producto ACTIVO asignado ");
        }

        int numeroCuenta = generarNumeroCuenta(tipoCuenta);

        Product producto = new Product(null, tipoCuenta, numeroCuenta, EstadoCuenta.ACTIVA, 0.0, false, idCliente);

        productRepository.registrarProducto(producto);
    }

    private int generarNumeroCuenta(TipoCuenta tipoCuenta) {
        StringBuilder numeroCuentaBuilder = new StringBuilder();

        if (tipoCuenta == TipoCuenta.CUENTA_AHORROS) {
            numeroCuentaBuilder.append("53");
        } else if (tipoCuenta == TipoCuenta.CUENTA_CORRIENTE) {
            numeroCuentaBuilder.append("33");
        } else {
            throw new CustomException("Tipo de cuenta no válido");
        }

        Random random = new Random();
        int longitudNumero = 8;
        for (int i = 0; i < longitudNumero; i++) {
            numeroCuentaBuilder.append(random.nextInt(10));
        }

        return Integer.parseInt(numeroCuentaBuilder.toString());
    }
}
