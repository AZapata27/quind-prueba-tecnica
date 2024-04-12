package dev.andreszapata.bankfuse.domain.repository;

import dev.andreszapata.bankfuse.domain.model.Product;

public interface ProductoRepository {
    void registrarProducto(Product producto);
    void actualizarProducto(Product producto);
    void eliminarProducto(Long idProducto);
    Product obtenerProductoPorId(Long idProducto);
}
