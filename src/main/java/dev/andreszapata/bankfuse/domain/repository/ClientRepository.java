package dev.andreszapata.bankfuse.domain.repository;

import dev.andreszapata.bankfuse.domain.model.Client;

public interface ClientRepository {
    void registrarCliente(Client cliente);
    void actualizarCliente(Client cliente);
    void eliminarCliente(Long idCliente);
    boolean existeCliente(Long idCliente);
    boolean tieneProductosVinculadosActivos(Long idCliente);
}
