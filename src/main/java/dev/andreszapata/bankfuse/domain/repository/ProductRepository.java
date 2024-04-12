package dev.andreszapata.bankfuse.domain.repository;

import dev.andreszapata.bankfuse.domain.model.Product;

public interface ProductRepository {
    void registrarProducto(Product producto);
    void actualizarProducto(Product producto);
    void eliminarProducto(Long idProducto);
    Product obtenerProductoPorId(Long idProducto);
    boolean existeProducto(Long idProducto);
    boolean existeProductoActivoByClientId(Long idClient);

    void actualizarSaldoProducto(Long idProduct, Double nuevoSaldo);

    Double obtenerSaldoProducto(Long idProduct);
}
