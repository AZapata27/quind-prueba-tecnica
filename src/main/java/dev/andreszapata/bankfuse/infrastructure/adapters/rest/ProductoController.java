package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.application.service.ProductoApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoApplicationService productoApplicationService;

    @PostMapping
    public ResponseEntity<String> crearProducto(@RequestBody ProductoRequest productoRequest) {
        productoApplicationService.crearProducto(productoRequest);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long idProducto, @RequestBody ProductoRequest productoRequest) {
        productoApplicationService.actualizarProducto(idProducto, productoRequest);
        return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<String> cancelarProducto(@PathVariable Long idProducto) {
        productoApplicationService.cancelarProducto(idProducto);
        return new ResponseEntity<>("Producto cancelado exitosamente", HttpStatus.OK);
    }
}
