package dev.andreszapata.bankfuse.domain.usecases;

import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;

public class ActualizarClienteUseCase {
    private final ClientRepository clientRepository;

    public ActualizarClienteUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void ejecutar(Client cliente) {

        if (!clientRepository.existeCliente(cliente.getIdClient())) {
            throw new IllegalArgumentException("El cliente no existe");
        }

        clientRepository.actualizarCliente(cliente);
    }
}
