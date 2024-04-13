package dev.andreszapata.bankfuse.domain.usecases;

import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;

public class RegistrarClienteUseCase {
    private final ClientRepository clientRepository;

    public RegistrarClienteUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void ejecutar(Client cliente) {

        if (cliente.esMenorDeEdad()) {
            throw new IllegalArgumentException("El cliente debe ser mayor de edad");
        }

        if (!cliente.esFormatoCorreoValido()) {
            throw new IllegalArgumentException("El formato del correo electrónico es inválido");
        }

        if (!cliente.tieneLongitudNombreValida()) {
            throw new IllegalArgumentException("La longitud del nombre o apellidos es inválida");
        }

        clientRepository.registrarCliente(cliente);
    }
}
