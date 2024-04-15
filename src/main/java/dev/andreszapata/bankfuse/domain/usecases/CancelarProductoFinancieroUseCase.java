package dev.andreszapata.bankfuse.domain.usecases;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;

public class CancelarProductoFinancieroUseCase {
    private final ProductRepository productRepository;

    public CancelarProductoFinancieroUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void ejecutar(Long idProducto) {

        Product producto = productRepository.obtenerProductoPorId(idProducto);

        if (producto.getSaldo() != 0.0) {
            throw new CustomException("No se puede cancelar la cuenta con saldo distinto de $0");
        }

        producto.setEstadoCuenta(EstadoCuenta.CANCELADA);

        productRepository.actualizarProducto(producto);
    }
}
