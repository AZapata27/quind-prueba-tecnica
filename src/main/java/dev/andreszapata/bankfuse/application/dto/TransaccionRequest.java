package dev.andreszapata.bankfuse.application.dto;

import lombok.Data;

@Data
public class TransaccionRequest {
    private Long idCliente;
    private Long idProducto;
    private String tipoTransaccion;
}
