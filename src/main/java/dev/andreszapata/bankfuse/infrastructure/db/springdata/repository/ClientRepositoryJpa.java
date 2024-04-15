package dev.andreszapata.bankfuse.infrastructure.db.springdata.repository;

import dev.andreszapata.bankfuse.infrastructure.db.springdata.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT COUNT(p) > 0 FROM ProductEntity p WHERE p.clientEntity.idClient = :idCliente AND p.estadoCuenta = 'ACTIVA'")
    boolean clienteTieneProductoActivo(@Param("idCliente") Long idCliente);
}