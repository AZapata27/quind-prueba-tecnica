package dev.andreszapata.bankfuse.infrastructure.adapters.repository;

import dev.andreszapata.bankfuse.domain.model.Client;
import dev.andreszapata.bankfuse.domain.repository.ClientRepository;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.mapper.ClientMapper;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.repository.ClientRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientAdapterRepository implements ClientRepository {


    private final ClientRepositoryJpa clientRepositoryJpa;



    @Override
    public void registrarCliente(Client cliente) {
        clientRepositoryJpa.save(ClientMapper.INSTANCE.domainToEntity(cliente));

    }

    @Override
    public void actualizarCliente(Client cliente) {
        clientRepositoryJpa.save(ClientMapper.INSTANCE.domainToEntity(cliente));
    }

    @Override
    public void eliminarCliente(Long idCliente) {
        clientRepositoryJpa.deleteById(idCliente);

    }

    @Override
    public boolean existeCliente(Long idCliente) {
        return clientRepositoryJpa.existsById(idCliente);
    }

    @Override
    public boolean tieneProductosVinculadosActivos(Long idCliente) {

        return clientRepositoryJpa.clienteTieneProductoActivo(idCliente);
    }
}
