package dev.andreszapata.bankfuse.infrastructure.rest.controller;

import dev.andreszapata.bankfuse.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    
    private final RegistrarProductoService registrarProductoService;
    private final ActualizarProductoService actualizarProductoService;
    private final EliminarProductoService eliminarProductoService;

    @PostMapping
    public ResponseEntity<String> registrarProducto(@RequestBody Product producto) {
        registrarProductoService.ejecutar(producto);
        return new ResponseEntity<>("Producto registrado exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long idProducto, @RequestBody Product producto) {
        actualizarProductoService.ejecutar(producto);
        return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long idProducto) {
        eliminarProductoService.ejecutar(idProducto);
        return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
    }
}
