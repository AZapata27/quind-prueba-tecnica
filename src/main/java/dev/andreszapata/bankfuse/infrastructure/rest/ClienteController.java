package dev.andreszapata.bankfuse.infrastructure.rest;

import dev.andreszapata.bankfuse.application.dto.ClienteRequest;
import dev.andreszapata.bankfuse.application.service.ClienteApplicationService;
import dev.andreszapata.bankfuse.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteApplicationService clienteApplicationService;

    @PostMapping
    public ResponseEntity<String> registrarCliente(@RequestBody ClienteRequest clienteRequest) {
        clienteApplicationService.registrarCliente(clienteRequest);
        return new ResponseEntity<>("Cliente registrado exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteRequest clienteRequest) {
        clienteApplicationService.actualizarCliente(idCliente, clienteRequest);
        return new ResponseEntity<>("Cliente actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long idCliente) {
        clienteApplicationService.eliminarCliente(idCliente);
        return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
    }
}
