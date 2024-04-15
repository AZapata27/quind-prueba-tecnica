package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.ClienteRequest;
import dev.andreszapata.bankfuse.application.mapper.ClientRequestMapper;
import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.usecases.ActualizarClienteUseCase;
import dev.andreszapata.bankfuse.domain.usecases.EliminarClienteUseCase;
import dev.andreszapata.bankfuse.domain.usecases.RegistrarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    private final RegistrarClienteUseCase registrarClienteUseCase;
    private final ActualizarClienteUseCase actualizarClienteUseCase;
    private final EliminarClienteUseCase eliminarClienteUseCase;
    private final ClientRequestMapper clientRequestMapper;


    public Long registrarCliente(ClienteRequest clienteRequest) {
        Client cliente = clientRequestMapper.requestToDomain(clienteRequest);

        return registrarClienteUseCase.ejecutar(cliente);
    }

    public void actualizarCliente(Long idCliente, ClienteRequest clienteRequest) {

        Client cliente = clientRequestMapper.requestToDomain(clienteRequest);
        actualizarClienteUseCase.ejecutar(cliente);

    }

    public void eliminarCliente(Long idCliente) {
        eliminarClienteUseCase.ejecutar(idCliente);
    }

}
