package dev.andreszapata.bankfuse.domain.repository;

import dev.andreszapata.bankfuse.domain.model.Transaction;

public interface TransaccionRepository {
    void registrarTransaccion(Transaction transaccion);
}
