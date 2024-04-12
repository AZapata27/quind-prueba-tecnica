package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.TransaccionRequest;
import dev.andreszapata.bankfuse.domain.model.Transaction;
import dev.andreszapata.bankfuse.domain.usecases.RegistrarTransaccionUseCase;

public class TransaccionApplicationService {

    private final RegistrarTransaccionUseCase registrarTransaccionUseCase;

    public TransaccionApplicationService(RegistrarTransaccionUseCase registrarTransaccionUseCase) {
        this.registrarTransaccionUseCase = registrarTransaccionUseCase;
    }

    public void registrarTransaccion(TransaccionRequest transaccionRequest) {
        Transaction transaccion = mapToTransaccion(transaccionRequest);
        registrarTransaccionUseCase.ejecutar(transaccion);
    }

    private Transaction mapToTransaccion(TransaccionRequest transaccionRequest) {
        Transaction transaccion = new Transaction();
        transaccion.setIdCliente(transaccionRequest.getIdCliente());
        transaccion.setIdProducto(transaccionRequest.getIdProducto());
        transaccion.setTipoTransaccion(transaccionRequest.getTipoTransaccion());
        return transaccion;
    }
}
