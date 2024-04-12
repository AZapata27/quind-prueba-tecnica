package dev.andreszapata.bankfuse.domain.model;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.enums.TipoCuenta;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class Product {

    private Long idProduct;
    private TipoCuenta tipoCuenta;
    private int numeroCuenta;
    private EstadoCuenta estadoCuenta;
    private Double saldo;
    private Boolean excentaGmf;
    private Client client;

}
