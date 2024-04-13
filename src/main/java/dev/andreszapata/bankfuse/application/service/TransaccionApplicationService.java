package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.TransaccionRequest;
import dev.andreszapata.bankfuse.domain.model.Transaction;
import dev.andreszapata.bankfuse.domain.usecases.RegistrarTransaccionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransaccionApplicationService implements TransaccionService {

    private final RegistrarTransaccionUseCase registrarTransaccionUseCase;

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
