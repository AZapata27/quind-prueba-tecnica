package dev.andreszapata.bankfuse.infrastructure.db.springdata.entity;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.enums.TipoTransaction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaccion", nullable = false)
    private Long idTransaccion;

    private Long idClient;

    private Long idProduct;

    private TipoTransaction tipoTransaction;
}
