package dev.andreszapata.bankfuse.infrastructure.adapters.repository;

import dev.andreszapata.bankfuse.domain.model.Transaction;
import dev.andreszapata.bankfuse.domain.repository.TransaccionRepository;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.mapper.TransactionMapper;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.repository.TransactionRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionAdapterRepository implements TransaccionRepository {

    private final TransactionRepositoryJpa transactionRepositoryJpa;
    private final TransactionMapper transactionMapper;


    @Override
    public void registrarTransaccion(Transaction transaccion) {
        transactionRepositoryJpa.save(transactionMapper.domainToEntity(transaccion));

    }

    @Override
    public List<Transaction> obtenerTransaccionesPorCliente(Long idCliente) {
        return transactionRepositoryJpa.findByIdClient(idCliente)
                .stream()
                .map(transactionMapper::entityToDomain)
                .toList();
    }
}
