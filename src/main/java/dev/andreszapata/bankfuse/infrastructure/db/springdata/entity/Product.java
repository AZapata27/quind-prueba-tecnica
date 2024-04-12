package dev.andreszapata.bankfuse.infrastructure.db.springdata.entity;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.enums.TipoCuenta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.ToOne;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto", nullable = false)
    private Long idProduct;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta", nullable = false)
    private TipoCuenta tipoCuenta;


    @Column(name = "numero_cuenta", nullable = false)
    private int numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cuenta", nullable = false)
    private EstadoCuenta estadoCuenta;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Column(name = "excenta_gmf", nullable = false)
    private Boolean excentaGmf;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Client client;

}
