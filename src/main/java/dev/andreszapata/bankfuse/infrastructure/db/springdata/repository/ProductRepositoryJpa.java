package dev.andreszapata.bankfuse.infrastructure.db.springdata.repository;

import dev.andreszapata.bankfuse.domain.enums.EstadoCuenta;
import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, Long> {


    boolean existsByIdAndEstadoCuenta(Long idClient,EstadoCuenta estadoCuenta);

    Optional<ProductEntity> findByNumeroCuenta(int numeroCuenta);


}