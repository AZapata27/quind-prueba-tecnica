package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.ClienteRequest;
import dev.andreszapata.bankfuse.application.dto.GenericResponse;
import dev.andreszapata.bankfuse.application.service.ClienteService;
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

    @Operation(summary = "Register a new client and return Id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client successfully registered"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @PostMapping
    public ResponseEntity<GenericResponse> registrarCliente(@RequestBody ClienteRequest clienteRequest) {


        Long idCliente = clienteService.registrarCliente(clienteRequest);

        var response = new GenericResponse();
        response.setMensajeRespuesta("Cliente registrado exitosamente");
        response.setId(idCliente);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client successfully updated"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @PutMapping("/{idCliente}")
    public ResponseEntity<GenericResponse> actualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteRequest clienteRequest) {
        clienteService.actualizarCliente(idCliente, clienteRequest);

        var response = new GenericResponse();
        response.setMensajeRespuesta("Cliente actualizado exitosamente");
        response.setId(idCliente);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary ="Delete an existing client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client successfully deleted"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<GenericResponse> eliminarCliente(@PathVariable Long idCliente) {
        clienteService.eliminarCliente(idCliente);

        var response = new GenericResponse();
        response.setMensajeRespuesta("Cliente eliminado exitosamente");
        response.setId(idCliente);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
