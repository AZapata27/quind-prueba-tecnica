package dev.andreszapata.bankfuse.domain.usecases;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.repository.ProductRepository;

public class CambiarEstadoProductoFinancieroUseCase {
    private final ProductRepository productRepository;

    public CambiarEstadoProductoFinancieroUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void ejecutar(Long idProducto, EstadoCuenta nuevoEstado) {

        Product producto = productRepository.obtenerProductoPorId(idProducto);

        producto.setEstadoCuenta(nuevoEstado);

        productRepository.actualizarProducto(producto);
    }
}
