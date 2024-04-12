package dev.andreszapata.bankfuse.domain.repository;

import dev.andreszapata.bankfuse.domain.model.Transaction;
import java.util.List;

public interface TransaccionRepository {
    void registrarTransaccion(Transaction transaccion);
    List<Transaction> obtenerTransaccionesPorCliente(Long idCliente);
}
