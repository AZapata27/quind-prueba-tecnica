package dev.andreszapata.bankfuse.infrastructure.adapters.rest;

import dev.andreszapata.bankfuse.application.dto.GenericResponse;
import dev.andreszapata.bankfuse.application.dto.ProductoRequest;
import dev.andreszapata.bankfuse.application.service.ProductoService;
import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
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
    public ResponseEntity<GenericResponse> crearProducto(@RequestBody ProductoRequest productoRequest) {
        Long idProducto = productoService.crearProducto(productoRequest);

        var response = new GenericResponse();
        response.setMensajeRespuesta("Producto creado exitosamente");
        response.setId(idProducto);


        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product successfully updated"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @PutMapping("/{idProducto}")
    public ResponseEntity<GenericResponse> actualizarProducto(@PathVariable Long idProducto, @RequestParam EstadoCuenta estadoCuenta) {
        productoService.actualizarProducto(idProducto, estadoCuenta);

        var response = new GenericResponse();
        response.setMensajeRespuesta("Producto actualizado exitosamente");
        response.setId(idProducto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Cancel an existing product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product successfully canceled"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<GenericResponse> cancelarProducto(@PathVariable Long idProducto) {
        productoService.cancelarProducto(idProducto);

        var response = new GenericResponse();
        response.setMensajeRespuesta("Producto actualizado exitosamente");
        response.setId(idProducto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
