package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.application.service.ProductoService;
import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<String> crearProducto(@RequestBody ProductoRequest productoRequest) {
        productoService.crearProducto(productoRequest);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long idProducto, @RequestParam EstadoCuenta estadoCuenta) {
        productoService.actualizarProducto(idProducto, estadoCuenta);
        return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<String> cancelarProducto(@PathVariable Long idProducto) {
        productoService.cancelarProducto(idProducto);
        return new ResponseEntity<>("Producto cancelado exitosamente", HttpStatus.OK);
    }
}
