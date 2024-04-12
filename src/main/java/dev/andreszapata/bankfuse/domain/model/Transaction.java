package dev.andreszapata.bankfuse.domain.model;

import dev.andreszapata.bankfuse.domain.enums.TipoTransaction;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    private Long idTransaccion;
    private Long idClient;
    private Long idProduct;
    private TipoTransaction tipoTransaction;

}
