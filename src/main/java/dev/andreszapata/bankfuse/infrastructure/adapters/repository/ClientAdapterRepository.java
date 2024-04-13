package dev.andreszapata.bankfuse.infrastructure.adapters.repository;

import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.repository.ClientRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientAdapterRepository implements ClientRepository {


    private final ClientRepositoryJpa clientRepositoryJpa;



    @Override
    public void registrarCliente(Client cliente) {

    }

    @Override
    public void actualizarCliente(Client cliente) {

    }

    @Override
    public void eliminarCliente(Long idCliente) {

    }

    @Override
    public boolean existeCliente(Long idCliente) {
        return false;
    }

    @Override
    public boolean tieneProductosVinculados(Long idCliente) {
        return false;
    }
}
