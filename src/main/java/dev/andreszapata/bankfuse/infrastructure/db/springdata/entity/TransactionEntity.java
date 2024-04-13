package dev.andreszapata.bankfuse.infrastructure.db.springdata.entity;

import dev.andreszapata.bankfuse.domain.enums.TipoTransaction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaccion", nullable = false)
    private Long idTransaccion;

    @Column(name = "id_cliente", nullable = false)
    private Long idClient;

    @Column(name = "id_product", nullable = false)
    private Long idProduct;

    @Column(name = "tipo_transaccion", nullable = false)
    private TipoTransaction tipoTransaction;

    @Column(name = "fecha_transaccion", nullable = false)
    private LocalDateTime fechaTransaccion;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
