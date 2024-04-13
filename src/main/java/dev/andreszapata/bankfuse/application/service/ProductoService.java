package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;

public interface ProductoService {

    /**
     * Crea un nuevo producto financiero.
     * @param productoRequest La información del producto a crear.
     */
    void crearProducto(ProductoRequest productoRequest);

    /**
     * Actualiza la información de un producto financiero existente.
     * @param idProducto El identificador del producto a actualizar.
     * @param productoRequest La nueva información del producto.
     */
    void actualizarProducto(Long idProducto, ProductoRequest productoRequest);

    /**
     * Cancela un producto financiero existente.
     * @param idProducto El identificador del producto a cancelar.
     */
    void cancelarProducto(Long idProducto);
}
