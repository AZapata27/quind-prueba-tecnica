package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.TransaccionRequest;
import dev.andreszapata.bankfuse.application.service.TransaccionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransaccionController {

    private final TransaccionService transaccionService;

    @Operation(summary = "Register a new transaction")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Transaction successfully registered"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @PostMapping
    public ResponseEntity<String> registrarTransaccion(@RequestBody TransaccionRequest transaccionRequest) {
        transaccionService.registrarTransaccion(transaccionRequest);
        return new ResponseEntity<>("Transacción registrada exitosamente", HttpStatus.CREATED);
    }
}
