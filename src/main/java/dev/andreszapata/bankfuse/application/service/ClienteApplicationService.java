package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.ClienteRequest;
import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.usecases.ActualizarClienteUseCase;
import dev.andreszapata.bankfuse.domain.usecases.EliminarClienteUseCase;
import dev.andreszapata.bankfuse.domain.usecases.RegistrarClienteUseCase;

public class ClienteApplicationService {

    private final RegistrarClienteUseCase registrarClienteUseCase;
    private final ActualizarClienteUseCase actualizarClienteUseCase;
    private final EliminarClienteUseCase eliminarClienteUseCase;

    public ClienteApplicationService(RegistrarClienteUseCase registrarClienteUseCase,
                                     ActualizarClienteUseCase actualizarClienteUseCase,
                                     EliminarClienteUseCase eliminarClienteUseCase) {
        this.registrarClienteUseCase = registrarClienteUseCase;
        this.actualizarClienteUseCase = actualizarClienteUseCase;
        this.eliminarClienteUseCase = eliminarClienteUseCase;
    }

    public void registrarCliente(ClienteRequest clienteRequest) {
        Client cliente = mapToClient(clienteRequest);
        registrarClienteUseCase.ejecutar(cliente);
    }

    public void actualizarCliente(Long idCliente, ClienteRequest clienteRequest) {
        Client cliente = mapToClient(clienteRequest);
        cliente.setIdCliente(idCliente);
        actualizarClienteUseCase.ejecutar(cliente);
    }

    public void eliminarCliente(Long idCliente) {
        eliminarClienteUseCase.ejecutar(idCliente);
    }

    private Client mapToClient(ClienteRequest clienteRequest) {
        Client cliente = new Client();
        cliente.setNombre(clienteRequest.getNombre());
        cliente.setApellido(clienteRequest.getApellido());
        // Mapear otros atributos...
        return cliente;
    }
}
