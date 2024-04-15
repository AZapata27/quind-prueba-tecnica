package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.ClienteRequest;
import dev.andreszapata.bankfuse.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> registrarCliente(@RequestBody ClienteRequest clienteRequest) {
        clienteService.registrarCliente(clienteRequest);
        return new ResponseEntity<>("Cliente registrado exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteRequest clienteRequest) {
        clienteService.actualizarCliente(idCliente, clienteRequest);
        return new ResponseEntity<>("Cliente actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long idCliente) {
        clienteService.eliminarCliente(idCliente);
        return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
    }
}
