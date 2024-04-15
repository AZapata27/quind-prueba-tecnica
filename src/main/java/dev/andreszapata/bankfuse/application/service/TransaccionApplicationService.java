package dev.andreszapata.bankfuse.application.service;

import dev.andreszapata.bankfuse.application.dto.TransaccionRequest;
import dev.andreszapata.bankfuse.application.mapper.TransaccionRequestMapper;
import dev.andreszapata.bankfuse.domain.model.Transaction;
import dev.andreszapata.bankfuse.domain.usecases.RegistrarTransaccionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransaccionApplicationService implements TransaccionService {

    private final RegistrarTransaccionUseCase registrarTransaccionUseCase;
    private final TransaccionRequestMapper transaccionRequestMapper;

    public void registrarTransaccion(TransaccionRequest transaccionRequest) {

        registrarTransaccionUseCase.ejecutar(transaccionRequestMapper.requestToEntity(transaccionRequest));
    }

}
