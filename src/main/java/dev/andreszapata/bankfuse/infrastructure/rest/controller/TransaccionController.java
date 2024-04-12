package dev.andreszapata.bankfuse.infrastructure.rest.controller;

import dev.andreszapata.bankfuse.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaccion")
@RequiredArgsConstructor
public class TransaccionController {
    
    private final RegistrarTransaccionService registrarTransaccionService;

    @PostMapping
    public ResponseEntity<String> registrarTransaccion(@RequestBody Transaction transaccion) {
        registrarTransaccionService.ejecutar(transaccion);
        return new ResponseEntity<>("Transacción registrada exitosamente", HttpStatus.CREATED);
    }
}
