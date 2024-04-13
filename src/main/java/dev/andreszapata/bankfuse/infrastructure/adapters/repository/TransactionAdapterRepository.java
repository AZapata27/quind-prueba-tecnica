package dev.andreszapata.bankfuse.infrastructure.adapters.repository;

import dev.andreszapata.bankfuse.domain.model.Transaction;
import dev.andreszapata.bankfuse.domain.repository.TransaccionRepository;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.repository.TransactionRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionAdapterRepository implements TransaccionRepository {

    private final TransactionRepositoryJpa transactionRepositoryJpa;


    @Override
    public void registrarTransaccion(Transaction transaccion) {

    }

    @Override
    public List<Transaction> obtenerTransaccionesPorCliente(Long idCliente) {
        return List.of();
    }
}
