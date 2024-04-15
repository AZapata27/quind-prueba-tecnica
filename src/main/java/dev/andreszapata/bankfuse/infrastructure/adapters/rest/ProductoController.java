package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.application.service.ProductoService;
import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @Operation(summary = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product successfully created"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @PostMapping
    public ResponseEntity<String> crearProducto(@RequestBody ProductoRequest productoRequest) {
        productoService.crearProducto(productoRequest);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product successfully updated"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @PutMapping("/{idProducto}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long idProducto, @RequestParam EstadoCuenta estadoCuenta) {
        productoService.actualizarProducto(idProducto, estadoCuenta);
        return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
    }

    @Operation(summary = "Cancel an existing product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product successfully canceled"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<String> cancelarProducto(@PathVariable Long idProducto) {
        productoService.cancelarProducto(idProducto);
        return new ResponseEntity<>("Producto cancelado exitosamente", HttpStatus.OK);
    }
}
