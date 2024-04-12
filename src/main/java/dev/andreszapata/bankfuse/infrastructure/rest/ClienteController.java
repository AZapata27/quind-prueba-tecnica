package dev.andreszapata.bankfuse.infrastructure.rest;

import dev.andreszapata.bankfuse.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {
    
    private final RegistrarClienteService registrarClienteService;
    private final ActualizarClienteService actualizarClienteService;
    private final EliminarClienteService eliminarClienteService;


    @PostMapping
    public ResponseEntity<String> registrarCliente(@RequestBody Client cliente) {
        registrarClienteService.ejecutar(cliente);
        return new ResponseEntity<>("Cliente registrado exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Long idCliente, @RequestBody Client cliente) {
        actualizarClienteService.ejecutar(cliente);
        return new ResponseEntity<>("Cliente actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long idCliente) {
        eliminarClienteService.ejecutar(idCliente);
        return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
    }
}
