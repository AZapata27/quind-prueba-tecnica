package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.application.mapper.ProductRequestMapper;
import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.model.Product;
import dev.andreszapata.bankfuse.domain.usecases.CambiarEstadoProductoFinancieroUseCase;
import dev.andreszapata.bankfuse.domain.usecases.CancelarProductoFinancieroUseCase;
import dev.andreszapata.bankfuse.domain.usecases.CrearProductoFinancieroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoApplicationService implements  ProductoService{

    private final CrearProductoFinancieroUseCase crearProductoFinancieroUseCase;
    private final CambiarEstadoProductoFinancieroUseCase cambiarEstadoProductoFinancieroUseCase;
    private final CancelarProductoFinancieroUseCase cancelarProductoFinancieroUseCase;

    public void crearProducto(ProductoRequest productoRequest) {

        crearProductoFinancieroUseCase.ejecutar(productoRequest.getTipoCuenta(), productoRequest.getIdCliente());
    }

    public void actualizarProducto(Long idProducto, EstadoCuenta estadoCuenta) {
        cambiarEstadoProductoFinancieroUseCase.ejecutar(idProducto,estadoCuenta);
    }

    public void cancelarProducto(Long idProducto) {
        cancelarProductoFinancieroUseCase.ejecutar(idProducto);
    }

}
