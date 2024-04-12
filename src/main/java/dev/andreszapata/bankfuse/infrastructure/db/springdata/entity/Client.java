package dev.andreszapata.bankfuse.infrastructure.db.springdata.entity;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.enums.TipoIdentificacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", nullable = false)
    private Long idClient;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_identificacion", nullable = false)
    private TipoIdentificacion tipoIdentificacion;


    @Column(name = "numero_identificacion", nullable = false)
    private int numeroIdentificacion;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @OneToOne(mappedBy = "client")
    private Product product;

}
