package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.ClienteRequest;
import dev.andreszapata.bankfuse.application.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @Operation(summary = "Register a new client")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client successfully registered"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @PostMapping
    public ResponseEntity<String> registrarCliente(@RequestBody ClienteRequest clienteRequest) {
        clienteService.registrarCliente(clienteRequest);
        return new ResponseEntity<>("Cliente registrado exitosamente", HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client successfully updated"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @PutMapping("/{idCliente}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteRequest clienteRequest) {
        clienteService.actualizarCliente(idCliente, clienteRequest);
        return new ResponseEntity<>("Cliente actualizado exitosamente", HttpStatus.OK);
    }

    @Operation(summary ="Delete an existing client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client successfully deleted"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long idCliente) {
        clienteService.eliminarCliente(idCliente);
        return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
    }
}
