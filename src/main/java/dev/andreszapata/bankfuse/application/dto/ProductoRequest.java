package dev.andreszapata.bankfuse.application.dto;

import dev.andreszapata.bankfuse.domain.enums.TipoCuenta;
import lombok.Data;

@Data
public class ProductoRequest {
    private TipoCuenta tipoCuenta;
    private String numeroCuenta;
    private String estadoCuenta;
    private Double saldo;
    private Boolean exentaGmf;
    private Long idCliente;
}
