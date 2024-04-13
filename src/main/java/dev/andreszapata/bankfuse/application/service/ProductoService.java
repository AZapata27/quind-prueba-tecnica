package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;

public interface ProductoService {

    /**
     * Crea un nuevo producto financiero.
     * @param productoRequest La información del producto a crear.
     */
    void crearProducto(ProductoRequest productoRequest);

    /**
     * Actualiza la información de un producto financiero existente.
     * @param idProducto El identificador del producto a actualizar.
     * @param estadoCuenta El nuevo estado del producto.
     */
    void actualizarProducto(Long idProducto, EstadoCuenta estadoCuenta);

    /**
     * Cancela un producto financiero existente.
     * @param idProducto El identificador del producto a cancelar.
     */
    void cancelarProducto(Long idProducto);
}
