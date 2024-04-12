package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.usecases.CambiarEstadoProductoFinancieroUseCase;
import dev.andreszapata.bankfuse.domain.usecases.CancelarProductoFinancieroUseCase;
import dev.andreszapata.bankfuse.domain.usecases.CrearProductoFinancieroUseCase;

public class ProductoApplicationService {

    private final CrearProductoFinancieroUseCase crearProductoFinancieroUseCase;
    private final CambiarEstadoProductoFinancieroUseCase cambiarEstadoProductoFinancieroUseCase;
    private final CancelarProductoFinancieroUseCase cancelarProductoFinancieroUseCase;

    public ProductoApplicationService(CrearProductoFinancieroUseCase crearProductoFinancieroUseCase,
                                      CambiarEstadoProductoFinancieroUseCase cambiarEstadoProductoFinancieroUseCase,
                                      CancelarProductoFinancieroUseCase cancelarProductoFinancieroUseCase) {
        this.crearProductoFinancieroUseCase = crearProductoFinancieroUseCase;
        this.cambiarEstadoProductoFinancieroUseCase = cambiarEstadoProductoFinancieroUseCase;
        this.cancelarProductoFinancieroUseCase = cancelarProductoFinancieroUseCase;
    }

    public void crearProducto(ProductoRequest productoRequest) {
        Product producto = mapToProducto(productoRequest);
        crearProductoFinancieroUseCase.ejecutar(producto);
    }

    public void actualizarProducto(Long idProducto, ProductoRequest productoRequest) {
        Product producto = mapToProducto(productoRequest);
        producto.setId(idProducto);
        cambiarEstadoProductoFinancieroUseCase.ejecutar(producto);
    }

    public void cancelarProducto(Long idProducto) {
        cancelarProductoFinancieroUseCase.ejecutar(idProducto);
    }

    private Product mapToProducto(ProductoRequest productoRequest) {
        Product producto = new Product();
        producto.setTipoCuenta(productoRequest.getTipoCuenta());
        producto.setNumeroCuenta(productoRequest.getNumeroCuenta());
        return producto;
    }
}
