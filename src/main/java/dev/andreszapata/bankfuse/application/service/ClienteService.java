package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.ClienteRequest;

public interface ClienteService {

    /**
     * Registra un nuevo cliente.
     * @param clienteRequest La información del cliente a registrar.
     * @return Long idCliente recien creado
     */
    Long registrarCliente(ClienteRequest clienteRequest);

    /**
     * Actualiza la información de un cliente existente.
     * @param idCliente El identificador del cliente a actualizar.
     * @param clienteRequest La nueva información del cliente.
     */
    void actualizarCliente(Long idCliente, ClienteRequest clienteRequest);

    /**
     * Elimina un cliente existente.
     * @param idCliente El identificador del cliente a eliminar.
     */
    void eliminarCliente(Long idCliente);
}
