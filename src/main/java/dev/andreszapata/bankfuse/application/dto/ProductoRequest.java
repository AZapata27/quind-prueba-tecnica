package dev.andreszapata.bankfuse.application.dto;

import dev.andreszapata.bankfuse.domain.enums.TipoCuenta;
import lombok.Data;

@Data
public class ProductoRequest {

    public Long idCliente;
    private TipoCuenta tipoCuenta;
    private Boolean exentaGmf;
}
