package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.TransaccionRequest;
import dev.andreszapata.bankfuse.application.service.TransaccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransaccionController {

    private final TransaccionService transaccionService;

    @PostMapping
    public ResponseEntity<String> registrarTransaccion(@RequestBody TransaccionRequest transaccionRequest) {
        transaccionService.registrarTransaccion(transaccionRequest);
        return new ResponseEntity<>("Transacción registrada exitosamente", HttpStatus.CREATED);
    }
}
