package dev.andreszapata.bankfuse.infrastructure.rest;

import dev.andreszapata.bankfuse.application.dto.TransaccionRequest;
import dev.andreszapata.bankfuse.application.service.TransaccionApplicationService;
import dev.andreszapata.bankfuse.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaccion")
@RequiredArgsConstructor
public class TransaccionController {

    private final TransaccionApplicationService transaccionApplicationService;

    @PostMapping
    public ResponseEntity<String> registrarTransaccion(@RequestBody TransaccionRequest transaccionRequest) {
        transaccionApplicationService.registrarTransaccion(transaccionRequest);
        return new ResponseEntity<>("Transacción registrada exitosamente", HttpStatus.CREATED);
    }
}
