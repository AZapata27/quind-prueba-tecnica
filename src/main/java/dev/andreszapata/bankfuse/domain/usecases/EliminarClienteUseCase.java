package dev.andreszapata.bankfuse.domain.usecases;

import dev.andreszapata.bankfuse.domain.exceptions.CustomException;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;

public class EliminarClienteUseCase {
    private final ClientRepository clientRepository;

    public EliminarClienteUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void ejecutar(Long idCliente) {

        if (clientRepository.tieneProductosVinculadosActivos(idCliente)) {
            throw new CustomException("El cliente tiene productos vinculados y no puede ser eliminado");
        }

        clientRepository.eliminarCliente(idCliente);
    }
}
