package dev.andreszapata.bankfuse.domain.model;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.domain.enums.TipoCuenta;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long idProduct;
    private TipoCuenta tipoCuenta;
    private int numeroCuenta;
    private EstadoCuenta estadoCuenta;
    private Double saldo;
    private Boolean excentaGmf;
    private Client client;

}
