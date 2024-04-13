package dev.andreszapata.bankfuse.application.dto;

import dev.andreszapata.bankfuse.domain.enums.TipoCuenta;
import lombok.Data;

@Data
public class ProductoRequest {

    public Long idCliente;
    private TipoCuenta tipoCuenta;
    private String numeroCuenta;
    private String estadoCuenta;
    private Double saldo;
    private Boolean exentaGmf;
}
