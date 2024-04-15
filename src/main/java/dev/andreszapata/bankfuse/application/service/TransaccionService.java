package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.TransaccionRequest;

public interface TransaccionService {

    /**
     * Registra una nueva transacción.
     * @param transaccionRequest La información de la transacción a registrar.
     */
    void registrarTransaccion(TransaccionRequest transaccionRequest);
}
